package FundamentalsMoreExercises1;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String digit = scanner.nextLine();
            int length = digit.length();
            char firstNumber = digit.charAt(0);
            int mainDigit = Character.getNumericValue(firstNumber);
            if (mainDigit == 0) {
                System.out.print(" ");
                continue;
            }
            int offSet = (mainDigit - 2) * 3;
            if (mainDigit == 8 || mainDigit == 9) {
                offSet += 1;
            }
            int letterIndex = (offSet + length - 1);
            System.out.printf("%c", 'a' + letterIndex);
        }
    }
}
