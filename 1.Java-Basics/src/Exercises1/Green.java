package Exercises;

import java.util.Scanner;

public class Green {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double meters = Double.parseDouble(scanner.nextLine());
        double a = 7.61;
        double f = meters * a;
        double b = 0.18;
        double c = b * f;
        double e = f - c;
        System.out.println("The final price is: " + e);
        System.out.println("The discount is : " + c);

    }
}
