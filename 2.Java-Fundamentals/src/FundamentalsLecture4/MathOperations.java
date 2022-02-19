package FundamentalsLecture4;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number1 = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();
        double number2 = Double.parseDouble(scanner.nextLine());
        System.out.printf("%.0f", calculate(number1, operator, number2));
    }

    private static double calculate(double number1, String operator, double number2) {
        double result = 0.0;

        switch (operator) {
            case "/":
                result = number1 / number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
        }
        return result;
    }
}
