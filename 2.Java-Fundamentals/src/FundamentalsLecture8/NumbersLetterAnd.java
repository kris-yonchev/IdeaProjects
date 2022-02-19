package FundamentalsLecture8;

import java.util.Scanner;

public class NumbersLetterAnd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();
        String digits = "";
        String letters = "";
        String chars = "";
        for (int i = 0; i < words.length(); i++) {
            char symbol = words.charAt(i);
            if (Character.isAlphabetic(symbol)) {
                letters += symbol;
            } else if (Character.isDigit(symbol)) {
                digits += symbol;
            } else {
                chars += symbol;
            }
        }
        System.out.printf("%s\n%s\n%s\n", digits, letters, chars);
    }
}
