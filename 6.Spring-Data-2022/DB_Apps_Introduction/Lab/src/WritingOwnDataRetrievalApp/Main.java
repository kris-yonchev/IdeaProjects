package WritingOwnDataRetrievalApp;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username:");
        String user = scanner.nextLine();
        System.out.println("Please enter your password");
        String password = scanner.nextLine();


        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", properties);

        PreparedStatement statement = connection.prepareStatement("SELECT u.user_name, u.first_name, u.last_name," +
                "COUNT(ug.game_id) AS games_played FROM users AS u\n" +
                "JOIN users_games AS ug ON ug.user_id = u.id\n" +
                "WHERE u.user_name = ?\n" +
                "GROUP BY u.id");

        String userInput = scanner.nextLine();
        statement.setString(1, userInput);

        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            System.out.printf("User: %s\n%s %s has played %d games",
                    rs.getString("user_name"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getInt("games_played"));
        } else {
            System.out.println("No such user exists");
        }


        connection.close();

    }
}
