package Problem1_GetVillainNames;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(DBConnection.URL_DB);

        PreparedStatement statement = connection.prepareStatement(
                "SELECT v.name, COUNT(DISTINCT mv.minion_id) AS minion_count FROM villains AS v\n" +
                "JOIN minions_villains AS mv ON mv.villain_id = v.id\n" +
                "GROUP BY v.name\n" +
                "HAVING minion_count > 15\n" +
                "ORDER BY minion_count DESC");

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.printf("%s %d\n",
                    rs.getString("name"),
                    rs.getInt("minion_count"));
        }
        connection.close();
    }
}
