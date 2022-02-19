package Exercises2;

import java.util.Scanner;

public class Transsport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String daynight = scanner.nextLine();
        double result = 0.00;
        if (n >= 100) {
            result = 0.06 * n;
        } else if (n >= 20) {
            result = 0.09 * n;
        } else {
            if (daynight.equals("day")) {
                result = 0.70 + 0.79 * n;
            } else if (daynight.equals("night")) {
                result = 0.70 + 0.90 * n;
            }
        }
        System.out.printf("%.2f", result);
    }
}
