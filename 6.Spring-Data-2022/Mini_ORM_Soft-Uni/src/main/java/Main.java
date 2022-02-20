import entities.User;
import orm.EntityManager;
import orm.MyConnector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {

        MyConnector.createConnection("root", "peshomisho123", "test");

        Connection connection = MyConnector.getConnection();

        EntityManager<User> entityManager = new EntityManager<>(connection);

        User user = new User("Pesho", 40, LocalDate.now());

        entityManager.persist(user);
        User found = entityManager.findFirst(User.class, "age>30");

    }
}
