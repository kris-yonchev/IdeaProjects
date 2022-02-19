package Exercises;

import java.util.Scanner;

public class Zoo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dogs = Integer.parseInt(scanner.nextLine());
        int cats = Integer.parseInt(scanner.nextLine());
        double a = 2.50 * dogs;
        int b = 4 * cats;
        double f = a + b;
        System.out.printf(f + " lv. ");

    }
}
