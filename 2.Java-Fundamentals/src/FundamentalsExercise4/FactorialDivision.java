package FundamentalsExercise4;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n1 = Double.parseDouble(scanner.nextLine());
        double n2 = Double.parseDouble(scanner.nextLine());
        double result = getFactorial(n1) / getFactorial(n2);

        System.out.printf("%.2f", result);

    }
    private static double getFactorial(double n) {
        if (n == 0) {
            return 1;
        } else {
            return (n * getFactorial (n-1));
        }

    }

}
