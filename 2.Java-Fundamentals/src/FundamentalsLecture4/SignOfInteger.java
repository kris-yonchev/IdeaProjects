package FundamentalsLecture4;

import java.util.Scanner;

public class SignOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        numbersIsPositive(number);
        numberIsZero(number);
        numberIsNegative(number);
    }


    private static void numbersIsPositive(int number) {
        if (number > 0) {
            System.out.printf("The number %d is positive.", number);
        }
    }

    private static void numberIsZero(int number) {
        if (number == 0) {
            System.out.printf("The number %d is zero.", number);
        }
    }

    private static void numberIsNegative(int number) {
        if (number < 0) {
            System.out.printf("The number %d is negative.", number);
        }
    }
}
