package FundamentalsExercise4;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        findCharacter(input);
    }

    private static void findCharacter(String input) {
        if (input.length() % 2 == 0) {
            char symbol1 = input.charAt(0);
            char symbol2 = input.charAt(0);
            for (int i = 0; i < input.length(); i++) {
                symbol1 = input.charAt(input.length() / 2);
                symbol2 = input.charAt(input.length() / 2 - 1);
            }
            System.out.printf("%c%c", symbol2, symbol1);
        } else {
            char symbol = input.charAt(0);
            for (int i = 0; i < input.length(); i++) {
                symbol = input.charAt(input.length() / 2);
            }
            System.out.printf("%c", symbol);
        }
    }
}
