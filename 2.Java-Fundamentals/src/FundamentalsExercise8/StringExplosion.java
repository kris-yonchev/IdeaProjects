package FundamentalsExercise8;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder text = new StringBuilder(input);
        int bombPower = 0;
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (bombPower > 0 && symbol != '>') {
                text.deleteCharAt(i);
                bombPower--;
                i--;
            }
            if (symbol == '>') {
                bombPower += text.charAt(i + 1) - 48;
            }
        }
        System.out.println(text);
    }
}
