package FundamentalsExercise4;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        int ffs = hasCharacters(pass) + hasOnlyLettersAndDigits(pass) + hasEnoughDigits(pass);
        if (ffs == 3) {
            System.out.println("Password is valid");
        }

    }

    public static int hasCharacters(String pass) {

        if (pass.length() <= 10 && pass.length() >= 6) {
            return 1;
        }
        System.out.println("Password must be between 6 and 10 characters");
        return 0;
    }

    public static int hasOnlyLettersAndDigits(String pass) {
        if (pass.matches("[(a-zA-Z0-9)]*")) {
            return 1;

        } else {
            System.out.println("Password must consist only of letters and digits");
            return 0;
        }

    }

    public static int hasEnoughDigits(String pass) {
        int digits = pass.replaceAll("\\D", "").length();
        if (digits >= 2) {
            return 1;
        }
        System.out.println("Password must have at least 2 digits");
        return 0;
    }


}
