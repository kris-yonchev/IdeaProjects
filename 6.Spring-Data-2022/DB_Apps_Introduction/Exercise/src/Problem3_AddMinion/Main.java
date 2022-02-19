package Problem3_AddMinion;

import Problem1_GetVillainNames.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = DriverManager.getConnection(DBConnection.URL_DB);
        String[] minionInfo = scanner.nextLine().split("\\s+");
        String[] villainInfo = scanner.nextLine().split("\\s+");

        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionCity = minionInfo[3];

        String villainName = villainInfo[1];


        if (!hasCity(connection, minionCity)) {
            PreparedStatement insertCity = connection.prepareStatement(
                    "INSERT INTO towns(name)\n" +
                            " VALUES(?)");
            insertCity.setString(1, minionCity);
            insertCity.executeUpdate();
            System.out.printf("Town %s was added to the database.\n", minionCity);
        }

        PreparedStatement insertMinion = connection.prepareStatement(
                "INSERT INTO minions(name, age, town_id)\n" +
                        " VALUES(?, ?, ?)");
        insertMinion.setString(1, minionName);
        insertMinion.setInt(2, minionAge);
        insertMinion.setInt(3, getTownId(connection, minionCity));
        insertMinion.executeUpdate();


        if (!hasVillain(connection, villainName)) {
            PreparedStatement insertVillain = connection.prepareStatement(
                    "INSERT INTO villains(name, evilness_factor)\n" +
                            " VALUES (?, ?)");
            insertVillain.setString(1, villainName);
            insertVillain.setString(2, "evil");
            insertVillain.executeUpdate();
            System.out.printf("Villain %s was added to the database.\n", villainName);
        }

        PreparedStatement addMinionToVillain = connection.prepareStatement(
                "INSERT INTO minions_villains(minion_id, villain_id)\n" +
                        " VALUES(?, ?)");
        addMinionToVillain.setInt(1, getMinionId(connection, minionName));
        addMinionToVillain.setInt(2, getVillainId(connection, villainName));

        System.out.printf("Successfully added %s to be minion of %s.\n", minionName, villainName);

        connection.close();

    }

    private static int getVillainId(Connection connection, String villainName) throws SQLException {
        PreparedStatement getId = connection.prepareStatement(
                "SELECT MAX(id) AS villain_id FROM villains\n" +
                        " WHERE name = ?");
        getId.setString(1, villainName);
        ResultSet rs = getId.executeQuery();
        rs.next();
        return rs.getInt("villain_id");
    }

    private static int getMinionId(Connection connection, String minionName) throws SQLException {
        PreparedStatement getId = connection.prepareStatement(
                "SELECT MAX(id) AS minion_id FROM minions\n" +
                        " WHERE name = ?");
        getId.setString(1, minionName);
        ResultSet rs = getId.executeQuery();
        rs.next();
        return rs.getInt("minion_id");
    }

    private static int getTownId(Connection connection, String minionCity) throws SQLException {
        PreparedStatement getId = connection.prepareStatement(
                "SELECT id FROM towns\n" +
                        " WHERE name = ? ORDER BY id DESC LIMIT 1");
        getId.setString(1, minionCity);
        ResultSet rs = getId.executeQuery();
        rs.next();
        return rs.getInt("id");
    }

    private static boolean hasVillain(Connection connection, String villainName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT name FROM villains\n" +
                        " WHERE name = ?");
        statement.setString(1, villainName);
        ResultSet rs = statement.executeQuery();
        return rs.next();
    }

    private static boolean hasCity(Connection connection, String minionCity) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT name FROM towns\n" +
                        " WHERE name = ?");
        statement.setString(1, minionCity);
        ResultSet rs = statement.executeQuery();
        return rs.next();
    }
}
