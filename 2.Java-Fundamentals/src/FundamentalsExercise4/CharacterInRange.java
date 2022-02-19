package FundamentalsExercise4;

import java.util.Scanner;

public class CharacterInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char char1 = scanner.nextLine().charAt(0);
        char char2 = scanner.nextLine().charAt(0);
        System.out.printf("%s", printCharRange(char1, char2));
    }

    private static String printCharRange(char char1, char char2) {
        String result = "";

        for (int i = Math.min(char1, char2) + 1; i < Math.max(char1, char2); i++) {
            char symbol = (char) i;
            result += symbol + " ";

        }
        return result;
    }
}
