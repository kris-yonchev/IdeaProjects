package Exercises3;

import java.util.Scanner;

public class MatchdayTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String type = scanner.nextLine();
        int people = Integer.parseInt(scanner.nextLine());
        double price = 0.0;
        double diff = 0.0;
        switch (type) {
            case "VIP":
                price = 499.99 * people;
                break;
            case "Normal":
                price = 249.99 * people;
                break;
        }
        if (people <= 4) {
            budget *= 0.25;
        } else if (people <= 9) {
            budget *= 0.4;
        } else if (people <= 24) {
            budget *= 0.5;
        } else if (people <= 49) {
            budget *= 0.6;
        } else {
            budget *= 0.75;
        }
        if (budget >= price) {
            diff = Math.abs(budget - price);
            System.out.printf("Yes! You have %.2f leva left.", diff);
        } else {
            diff = Math.abs(budget - price);
            System.out.printf("Not enough money! You need %.2f leva.", diff);
        }
    }
}
