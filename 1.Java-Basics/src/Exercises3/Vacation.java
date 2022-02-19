package Exercises3;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        double price = 0.0;
        String place = "";
        String type = "";
        switch (season) {
            case "Summer":
                place = "Alaska";
                if (budget <= 1000) {
                    type = "Camp";
                    price = budget * 0.65;
                } else if (budget <= 3000) {
                    type = "Hut";
                    price = budget * 0.8;
                }
                break;
            case "Winter":
                place = "Morocco";
                if (budget <= 1000) {
                    type = "Camp";
                    price = budget * 0.45;
                } else if (budget <= 3000) {
                    type = "Hut";
                    price = budget * 0.6;
                }
                break;
        }
        if (budget > 3000) {
            type = "Hotel";
            price = budget * 0.9;
            switch (season) {
                case "Summer":
                    place = "Alaska";
                    break;
                case "Winter":
                    place = "Morocco";
                    break;
            }
        }
        System.out.printf("%s - %s - %.2f", place, type, price);
    }
}
