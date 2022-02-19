package Exercises3;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        double price = 0.00;
        boolean fivepercent = n % 2 == 0;
        switch (season) {
            case "Spring":
                price = 3000;
                break;
            case "Summer":
            case "Autumn":
                price = 4200;
                break;
            case "Winter":
                price = 2600;
                break;
        }
        if (n <= 6) {
            price *= 0.90;
        } else if (n >= 7 && n <= 11) {
            price *= 0.85;
        } else if (n >= 12) {
            price *= 0.75;
        }
        if (fivepercent && !(season.equals("Autumn"))) {
            price *= 0.95;
        }
        double missing = Math.abs(budget - price);
        if (budget >= price) {
            System.out.printf("Yes! You have %.2f leva left.", missing);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", missing);
        }

    }
}
