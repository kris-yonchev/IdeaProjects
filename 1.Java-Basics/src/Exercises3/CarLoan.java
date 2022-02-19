package Exercises3;

import java.util.Scanner;

public class CarLoan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String type = "";
        String car = "";
        double price = 0.0;
        switch (season) {
            case "Summer":
                if (budget <= 100) {
                    type = "Economy class";
                    car = "Cabrio";
                    price = budget * 0.35;
                } else if (budget <= 500) {
                    type = "Compact class";
                    car = "Cabrio";
                    price = budget * 0.45;
                }
                break;
            case "Winter":
                if (budget <= 100) {
                    type = "Economy class";
                    car = "Jeep";
                    price = budget * 0.65;
                } else if (budget <= 500) {
                    type = "Compact class";
                    car = "Jeep";
                    price = budget * 0.8;
                }
                break;
        }
        if (budget > 500) {
            car = "Jeep";
            type = "Luxury class";
            price = budget * 0.9;
        }
        System.out.printf("%s\n%s - %.2f", type, car, price);
    }
}
