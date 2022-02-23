package Problem2_GetMinionNames;

import Problem1_GetVillainNames.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String villainId = scanner.nextLine();

        Connection connection = DriverManager.getConnection(DBConnection.URL_DB);

        PreparedStatement getVillain = connection.prepareStatement("SELECT v.name FROM villains AS v\n" +
                "WHERE v.id = ?");
        getVillain.setString(1, villainId);

        ResultSet rs = getVillain.executeQuery();
        if (!rs.next()) {
            System.out.printf("No villain with ID %s exists in the database.", villainId);
            return;
        }
        System.out.printf("Villain: %s\n", rs.getString("name"));

        PreparedStatement getMinions = connection.prepareStatement(
                "SELECT m.name, m.age FROM minions AS m" +
                        " JOIN minions_villains AS mv ON m.id = mv.minion_id" +
                        " WHERE mv.villain_id = ?");
        getMinions.setString(1, villainId);

        ResultSet minions = getMinions.executeQuery();
        int counter = 1;
        while (minions.next()) {
            System.out.printf("%d. %s %s\n", counter++,
                    minions.getString("name"),
                    minions.getString("age"));
        }
        connection.close();
    }
}
