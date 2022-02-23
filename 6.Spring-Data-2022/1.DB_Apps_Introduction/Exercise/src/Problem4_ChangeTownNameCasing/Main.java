package Problem4_ChangeTownNameCasing;

import Problem1_GetVillainNames.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();

        Connection connection = DriverManager.getConnection(DBConnection.URL_DB);

        PreparedStatement caseChange = connection.prepareStatement(
                "UPDATE towns SET name = UPPER(name)\n" +
                        " WHERE country = ?");
        caseChange.setString(1, country);
        int updateCount = caseChange.executeUpdate();

        if (updateCount == 0) {
            System.out.println("No town names were affected.");
        }

        System.out.printf("%d town names were affected.\n", updateCount);
        PreparedStatement selectTowns = connection.prepareStatement(
                "SELECT name FROM towns\n" +
                        " WHERE country = ?");
        selectTowns.setString(1, country);
        ResultSet rs = selectTowns.executeQuery();

        List<String> towns = new ArrayList<>();

        while (rs.next()) {
            towns.add(rs.getString("name"));
        }

        System.out.println(towns);
        connection.close();

    }
}
