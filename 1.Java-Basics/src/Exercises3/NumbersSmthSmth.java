package Exercises3;

import java.util.Scanner;

public class NumbersSmthSmth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        String symbol = scanner.nextLine();
        double result = 0.00;
        String oddeven = "";
        switch (symbol) {
            case ("+"):
                result = n1 + n2;
                System.out.printf("%d + %d = %.0f - %s", n1, n2, result, oddeven);
                if (result % 2 == 0) {
                    System.out.println("even");
                } else {
                    System.out.println("odd");
                }
                break;
            case ("-"):
                result = n1 - n2;
                System.out.printf("%d - %d = %.0f - %s", n1, n2, result, oddeven);
                if (result % 2 == 0) {
                    System.out.println("even");
                } else {
                    System.out.println("odd");
                }
                break;
            case ("*"):
                result = n1 * n2;
                System.out.printf("%d * %d = %.0f - %s", n1, n2, result, oddeven);
                if (result % 2 == 0) {
                    System.out.println("even");
                } else {
                    System.out.println("odd");
                }
                break;
            case ("/"):
                result = (double) n1 / n2;
                if (n2 != 0) {
                    System.out.printf("%d / %d = %.2f", n1, n2, result);
                } else {
                    System.out.printf("Cannot divide %d by zero", n1);
                }
                break;
            case ("%"):
                if (n2 > 0) {
                    int modulus = n1%n2;
                    System.out.printf("%d %% %d = %d", n1, n2, modulus);
                } else {
                    System.out.printf("Cannot divide %d by zero", n1);
                }
                break;
        }
    }
}
