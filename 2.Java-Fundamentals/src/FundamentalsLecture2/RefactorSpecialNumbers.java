package FundamentalsLecture2;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        boolean isSpecial = false;
        for (int digit = 1; digit <= number; digit++) {
            int sum = 0;
            int currentDigit = digit;
            while (currentDigit > 0) {
                sum += currentDigit % 10;
                currentDigit = currentDigit / 10;
            }
            isSpecial = (sum == 5) || (sum == 7) || (sum == 11);
            if (isSpecial) {
                System.out.printf("%d -> True%n", digit);
            } else {

                System.out.printf("%d -> False%n", digit);
            }
        }


    }
}
