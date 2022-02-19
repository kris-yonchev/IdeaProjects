package Exercises;

import java.util.Scanner;

public class Perimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = Double.parseDouble(scanner.nextLine());
        double perimeter = 2 * Math.PI * r;
        double area = Math.PI * Math.pow(r,2);
        System.out.printf("%.2f%n%.2f", area ,perimeter);
    }
}
