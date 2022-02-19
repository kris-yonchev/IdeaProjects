package FundamentalsExercise8;

import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(encryptIt(input));

    }

    private static StringBuilder encryptIt(String input) {
        StringBuilder sb = new StringBuilder();
        for (char word : input.toCharArray()) {
            char symbol = (char) (word + 3);
            sb.append(symbol);
        }
        return sb;
    }
}
