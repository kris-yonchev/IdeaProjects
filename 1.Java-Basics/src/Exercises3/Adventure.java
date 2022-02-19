package Exercises3;

import java.util.Scanner;

public class Adventure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String destination = "";
        String stay = "";
        double price = 0.00;
        if (budget <= 100) {
            destination = "Bulgaria";
            if (season.equals("summer")) {
                stay = "Camp";
                price = budget * 0.3;
            } else if (season.equals("winter")) {
                stay = "Hotel";
                price = budget * 0.7;
            }
        } else if (budget <= 1000) {
            destination = "Balkans";
            if (season.equals("summer")) {
                stay = "Camp";
                price = budget * 0.4;
            } else if (season.equals("winter")) {
                stay = "Hotel";
                price = budget * 0.8;
            }
        } else if (budget > 1000) {
            destination = "Europe";
            stay = "Hotel";
            price = budget * 0.9;
        }
        System.out.printf("Somewhere in %s\n%s - %.2f", destination, stay, price);
    }
}
