package FundamentalsLecture4;

import java.util.Scanner;

public class MultipleEvenByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int multiple = getMultipleOfEvenAndOdds(Math.abs(n));
        System.out.println(multiple);

    }

    private static int getMultipleOfEvenAndOdds(int n) {
        int evenSum = getEvenSum(n);
        int oddSum = getOddSum(n);
        return evenSum * oddSum;
    }

    private static int getOddSum(int n) {
        int oddSum = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 != 0) {
                oddSum += digit;
            }
            n = n / 10;
        }
        return oddSum;

    }

    private static int getEvenSum(int n) {
        int evenSum = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 == 0) {
                evenSum += digit;
            }
            n = n / 10;
        }
        return evenSum;

    }
}
