package Exercises;

import java.util.Scanner;

public class Celcius {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double celc = Double.parseDouble(scanner.nextLine());
        double fahren = celc * 1.8 + 32;
        System.out.printf("%.2f", fahren);
    }
}
