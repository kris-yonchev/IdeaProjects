package Problem7_IncreaseMinionAge;

import Problem1_GetVillainNames.DBConnection;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int[] minionIds = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Connection connection = DriverManager.getConnection(DBConnection.URL_DB);
        PreparedStatement updateMinionAge = connection.prepareStatement(
                "UPDATE minions\n" +
                        "SET age = age + 1\n" +
                        "WHERE id = ?");

        PreparedStatement updateMinionName = connection.prepareStatement(
                "UPDATE minions\n" +
                        "SET name = LOWER(name)\n" +
                        "WHERE id = ?"
        );

        for (int currentId : minionIds) {
            updateMinionAge.setInt(1, currentId);
            updateMinionName.setInt(1, currentId);
            updateMinionAge.executeUpdate();
            updateMinionName.executeUpdate();

        }
        PreparedStatement getMinions = connection.prepareStatement("SELECT name, age FROM minions");
        ResultSet minions = getMinions.executeQuery();
        while (minions.next()) {
            System.out.printf("%s %s\n",
                    minions.getString("name"),
                    minions.getInt("age"));
        }
    }
}
