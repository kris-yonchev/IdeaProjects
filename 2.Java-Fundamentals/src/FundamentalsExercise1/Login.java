package FundamentalsExercise1;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder rp = new StringBuilder(input);
        String reversedUser = rp.reverse().toString();
        int counter = 0;
        boolean failed = true;
        String pass = scanner.nextLine();
        while (!pass.equals(reversedUser)) {
            counter++;
            if (counter == 4) {
                System.out.println("User " + input + " blocked!");
                failed = false;
                break;
            }
            System.out.println("Incorrect password. Try again.");
            pass = scanner.nextLine();
        }
        if (failed)
            System.out.println("User " + input + " logged in.");

    }
}
