package FundamentalsLecture4;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numberOne = Double.parseDouble(scanner.nextLine());
        double numberTwo = Double.parseDouble(scanner.nextLine());
        double result = mathPower(numberOne, numberTwo);
        System.out.println(new DecimalFormat("0.####").format(result));

    }

    private static double mathPower(double numberOne, double numberTwo) {
        return Math.pow(numberOne, numberTwo);
    }
}
