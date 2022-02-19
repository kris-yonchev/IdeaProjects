package Problem8_IncreaseAgeProcedure;

import Problem1_GetVillainNames.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int minionId = Integer.parseInt(scanner.nextLine());

        Connection connection = DriverManager.getConnection(DBConnection.URL_DB);

        PreparedStatement increaseAge = connection.prepareStatement("CALL usp_get_older(?)");
        increaseAge.setInt(1, minionId);

        increaseAge.executeUpdate();

        PreparedStatement selectMinion = connection.prepareStatement(
                "SELECT name, age FROM minions\n" +
                        " WHERE id = ?");

        selectMinion.setInt(1, minionId);
        ResultSet rs = selectMinion.executeQuery();

        while (rs.next()) {
            System.out.printf("%s %d\n",
                    rs.getString("name"),
                    rs.getInt("age"));
        }

        connection.close();
    }
}
