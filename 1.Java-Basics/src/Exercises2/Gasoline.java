package Exercises2;

import java.util.Locale;
import java.util.Scanner;

public class Gasoline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        double liters = Double.parseDouble(scanner.nextLine());
        if (type.equals("Gasoline") || type.equals("Gas") || type.equals("Diesel")) {
            if (liters >= 25) {
                System.out.printf("You have enough %s.", String.format(type).toLowerCase());
            } else if (liters < 25) {
                System.out.printf("Fill your tank with %s!",String.format(type).toLowerCase());
            }
        } else {
            System.out.println("Invalid fuel!");
        }
    }
}

