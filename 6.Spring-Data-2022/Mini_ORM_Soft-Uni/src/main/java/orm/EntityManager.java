package orm;

import annotations.Column;
import annotations.Entity;
import annotations.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EntityManager<E> implements DbContext<E> {

    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    private Field getId(Class<?> entity) {
        return Arrays.stream(entity.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entity does not have primary key"));
    }


    private boolean doUpdate(E entity, Field primaryKey) throws IllegalAccessException, SQLException {
        String tableName = getTableName(entity.getClass());
        String query = "UPDATE " + tableName;
        String columns = " SET ";
        String where = " WHERE ";

        Field[] fields = entity.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            Object value = field.get(entity);
            if (field.isAnnotationPresent(Id.class)) {
                where += this.getColumnName(field) + " = " + value;
            } else {
                if (value instanceof Date) {
                    columns += this.getColumnName(field) + " = '"
                            + new SimpleDateFormat("yyyy-MM-dd").format(value) + "'";
                } else if (value instanceof Integer) {
                    columns += this.getColumnName(field) + " = " + value;
                } else {
                    columns += this.getColumnName(field) + " = '" + value + "'";
                }

                if (i < fields.length - 1) {
                    columns += ",";
                }
            }
        }
        query += columns + where;

        return connection.prepareStatement(query).execute();
    }

    private String getColumnName(Field field) {
        String columnName = field.getAnnotation(Column.class).name();
        if (columnName.isEmpty()) {
            columnName = field.getName();
        }
        return columnName;
    }

    private boolean doInsert(E entity, Field primaryKey) throws IllegalAccessException, SQLException {
        String tableName = getTableName(entity.getClass());
        String tableFields = getColumnsWithoutId(entity.getClass());
        String tableValues = getColumnsValuesWithoutId(entity);
        String insertQuery = String.format("Insert INTO %s (%s) VALUES (?)", tableName, tableFields);

        return connection.prepareStatement(insertQuery).execute();
    }

    private String getColumnsValuesWithoutId(E entity) throws IllegalAccessException {
        Class<?> aClass = entity.getClass();
        List<Field> fields = Arrays.stream(aClass.getDeclaredFields())
                .filter(f -> !f.isAnnotationPresent(Id.class))
                .filter(f -> f.isAnnotationPresent(Column.class))
                .collect(Collectors.toList());
        List<String> values = new ArrayList<>();
        for (Field field : fields) {
            field.setAccessible(true);
            Object o = field.get(entity);
            if (o instanceof String || o instanceof LocalDate) {
                values.add("'" + o + "'");
            } else {
                values.add(o.toString());
            }
            values.add(o.toString());
        }
        return String.join(",", values);
    }

    private String getColumnsWithoutId(Class<?> aClass) {
        return Arrays.stream(aClass.getDeclaredFields())
                .filter(f -> !f.isAnnotationPresent(Id.class))
                .filter(f -> f.isAnnotationPresent(Column.class))
                .map(f -> f.getAnnotationsByType(Column.class))
                .map(a -> a[0].name())
                .collect(Collectors.joining(","));
    }

    private String getTableName(Class<?> aClass) {
        Entity[] annotationsByType = aClass.getAnnotationsByType(Entity.class);

        if (annotationsByType.length == 0) {
            throw new UnsupportedOperationException("Class must be Entity");
        }
        return annotationsByType[0].name();
    }

    @Override
    public boolean persist(E entity) throws SQLException, IllegalAccessException {
        Field primaryKey = getId(entity.getClass());
        primaryKey.setAccessible(true);
        Object value = primaryKey.get(entity);

        if (value == null || (long) value <= 0) {
            return doInsert(entity, primaryKey);
        }

        return doUpdate(entity, primaryKey);
    }

    @Override
    public Iterable<E> find(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, InstantiationException {
        return find(table, null);
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) throws SQLException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM " + table.getAnnotation(Entity.class).name() +
                " WHERE 1 " + (where != null ? " AND " + where : "");
        ResultSet resultSet = statement.executeQuery(query);

        List<E> entities = new ArrayList<>();
        while (resultSet.next()) {
            E entity = table.getDeclaredConstructor().newInstance();
            this.fillEntity(table, resultSet, entity);
            entities.add(entity);
        }

        return entities;
    }

    @Override
    public E findFirst(Class<E> table) throws SQLException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Statement statement = connection.createStatement();
        String tableName = getTableName(table);
        String query = String.format("SELECT * FROM %s LIMIT 1;", tableName);

        ResultSet rs = statement.executeQuery(query);
        E entity = table.getDeclaredConstructor().newInstance();
        rs.next();
        fillEntity(table, rs, entity);

        return entity;
    }

    @Override
    public E findFirst(Class<E> table, String where) throws SQLException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Statement statement = connection.createStatement();
        String tableName = getTableName(table);
        String query = String.format("SELECT * FROM %s %s LIMIT 1;", tableName,
                where != null ? " WHERE " + where : "");

        ResultSet rs = statement.executeQuery(query);
        E entity = table.getDeclaredConstructor().newInstance();
        rs.next();
        fillEntity(table, rs, entity);

        return entity;
    }

    private void fillEntity(Class<E> table, ResultSet rs, E entity) throws SQLException, IllegalAccessException {
        Field[] fields = Arrays.stream(table.getDeclaredFields()).toArray(Field[]::new);
        for (Field field : fields) {
            field.setAccessible(true);
            fillField(field, rs, entity);
        }
    }

    private void fillField(Field field, ResultSet rs, E entity) throws SQLException, IllegalAccessException {
        field.setAccessible(true);
        if (field.getType() == int.class || field.getType() == long.class) {
            field.set(entity, rs.getInt(field.getName()));
        } else if (field.getType() == LocalDate.class) {
            field.set(entity, LocalDate.parse(rs.getString(field.getName())));
        } else {
            field.set(entity, rs.getString(field.getName()));
        }
    }
}
