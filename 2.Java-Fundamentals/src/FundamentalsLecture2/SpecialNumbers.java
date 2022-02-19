package FundamentalsLecture2;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            int digits = i;
            int sum = 0;

            while (digits > 0) {
                int currentDigit = digits % 10;
                sum += currentDigit;
                digits = digits / 10;
            }
            if (sum == 7 || sum == 5 || sum == 11) {
                System.out.printf("%d -> True\n", i);
            } else {
                System.out.printf("%d -> False\n", i);
            }

        }
    }
}
