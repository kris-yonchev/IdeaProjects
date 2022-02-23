package Problem6_PrintAllMinionNames;

import Problem1_GetVillainNames.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(DBConnection.URL_DB);

        PreparedStatement getMinionNames = connection.prepareStatement("SELECT m.name FROM minions AS m");

        List<String> names = new ArrayList<>();

        ResultSet rs = getMinionNames.executeQuery();

        while (rs.next()) {
            names.add(rs.getString("name"));
        }

        for (int i = 0; i < names.size() / 2; i++) {
            System.out.println(names.get(i));
            System.out.println(names.get(names.size() - 1 - i));
        }

        connection.close();
    }
}
