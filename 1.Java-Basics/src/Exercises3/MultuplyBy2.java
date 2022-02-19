package Exercises3;

import java.util.Scanner;

public class MultuplyBy2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            double n = Double.parseDouble(scanner.nextLine());
            if (n < 0) {
                System.out.println("Negative number!");
                break;
            } else {
                double result = n * 2;
                System.out.printf("Result: %.2f\n", result);
            }
        }
    }
}