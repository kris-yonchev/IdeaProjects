package Exercises;

import java.util.Scanner;

public class Forecast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double temperature = Double.parseDouble(scanner.nextLine());

        if (temperature >= 26 && temperature <= 35) {
            System.out.println("Hot");
        } else if (temperature <= 26 && temperature >= 20.1) {
            System.out.println("Warm");
        } else if (temperature <= 20 && temperature >= 15) {
            System.out.println("Mild");
        } else if (temperature >= 12 && temperature <= 14.9) {
            System.out.println("Cool");
        } else if (temperature >= 5 && temperature <= 11.9) {
            System.out.println("Cold");
        } else {
            System.out.println("unknown");
        }
    }
}