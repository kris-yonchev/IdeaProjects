package FundamentalsExercise8;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] usernames = scanner.nextLine().split(", ");
        for (String username : usernames) {
            if (isValid(username)) {
                System.out.println(username);
            }
        }
    }

    private static boolean isValid(String username) {
        if (username.length() >= 3 && username.length() <= 16) {
            for (int i = 0; i < username.length(); i++) {
                char symbol = username.charAt(i);
                if (Character.isAlphabetic(symbol) || Character.isDigit(symbol) || symbol == '-' || symbol == '_') {

                } else {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
