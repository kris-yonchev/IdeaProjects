package FundamentalsExercise4;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            if (isDivisibleByEight(i)) {
                if (hasAtLeastOneOddDigit(i)) {
                    System.out.println(i);
                }
            }
        }
    }


    private static boolean isDivisibleByEight(int i) {
        int sum = 0;
        while (i > 0) {
            int digit = i % 10;
            sum += digit;
            i = i / 10;
        }
        return sum % 8 == 0;
    }

    private static boolean hasAtLeastOneOddDigit(int i) {
        while (i > 0) {
            int digit = i % 10;
            if (digit % 2 != 0) {
                return true;
            }
            i = i / 10;
        }
        return false;
    }


}
