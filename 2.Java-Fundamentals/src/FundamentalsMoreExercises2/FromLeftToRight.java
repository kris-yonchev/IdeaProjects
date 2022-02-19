package FundamentalsMoreExercises2;

import java.util.Scanner;

public class FromLeftToRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (long i = 1; i <= n; i++) {
            String numbers = scanner.nextLine();
            String[] parts = numbers.split(" ");
            String part1 = parts[0];
            String part2 = parts[1];
            long first = Long.parseLong(part1);
            long second = Long.parseLong(part2);
            long biggerNumber = Math.max(first, second);
            long sum = 0;
            while (biggerNumber != 0) {
                long digit = biggerNumber % 10;
                sum += digit;
                biggerNumber /= 10;

            }
            System.out.println(Math.abs(sum));

        }

    }
}
