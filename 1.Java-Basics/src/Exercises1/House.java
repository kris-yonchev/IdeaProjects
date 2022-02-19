package Exercises;

import java.util.Scanner;

public class House {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double sides = 2 * (x * y) - 2 * 2.25;
        double back = x * x;
        double frontandback = (2 * back) - (1.2 * 2);
        double bothsides = frontandback + sides;
        double tops = 2 * (x * y);
        double triangles = 2 * (x * h / 2);
        double greenpaint = bothsides / 3.4;
        double redpaint = (tops + triangles) / 4.3;


        System.out.printf("%.2f%n%.2f", greenpaint, redpaint);

    }
}
