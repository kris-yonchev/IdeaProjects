package Problem5_RemoveVillain;

import Problem1_GetVillainNames.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int villainId = Integer.parseInt(scanner.nextLine());
        Connection connection = DriverManager.getConnection(DBConnection.URL_DB);
        connection.setAutoCommit(false);

        PreparedStatement selectVillain = connection.prepareStatement("SELECT name FROM villains WHERE id = ?");
        selectVillain.setInt(1, villainId);
        ResultSet rs = selectVillain.executeQuery();

        PreparedStatement selectVillainMinions = connection.prepareStatement(
                "SELECT COUNT(DISTINCT minion_id) AS count FROM minions_villains\n" +
                        " WHERE villain_id = ?");
        selectVillainMinions.setInt(1, villainId);
        ResultSet getMinions = selectVillainMinions.executeQuery();
        getMinions.next();
        int minionsSetFree = getMinions.getInt("count");

        if (!rs.next()) {
            System.out.println("No such villain was found");
            return;
        }
        String villainName = rs.getString("name");

        try {
            PreparedStatement deleteMinionsVillains = connection.prepareStatement(
                    "DELETE FROM minions_villains\n" +
                            " WHERE villain_id = ?");
            deleteMinionsVillains.setInt(1, villainId);
            deleteMinionsVillains.executeUpdate();

            PreparedStatement deleteVillain = connection.prepareStatement(
                    "DELETE FROM villains\n" +
                            " WHERE id = ?");
            deleteVillain.setInt(1, villainId);
            deleteVillain.executeUpdate();

            connection.commit();
            System.out.printf("%s was deleted\n", villainName);
            System.out.printf("%d minions released\n", minionsSetFree);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
        }

        connection.close();
    }
}
