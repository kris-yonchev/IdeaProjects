package Exercises3;

import java.util.Scanner;

public class SummerCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String season = scanner.nextLine();
        String type = scanner.nextLine();
        int pupils = Integer.parseInt(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        String sport = "";
        double price = 0.0;
        switch (season) {
            case "Winter":
                if (type.equals("boys")) {
                    price = pupils * 9.60 * nights;
                    sport = "Judo";
                } else if (type.equals("girls")) {
                    price = pupils * 9.60 * nights;
                    sport = "Gymnastics";
                } else {
                    price = pupils * 10 * nights;
                    sport = "Ski";
                }
                break;
            case "Spring":
                if (type.equals("boys")) {
                    price = pupils * 7.20 * nights;
                    sport = "Tennis";
                } else if (type.equals("girls")) {
                    price = pupils * 7.20 * nights;
                    sport = "Athletics";
                } else {
                    price = pupils * 9.50 * nights;
                    sport = "Cycling";
                }
                break;
            case "Summer":
                if (type.equals("boys")) {
                    price = pupils * 15 * nights;
                    sport = "Football";
                } else if (type.equals("girls")) {
                    price = pupils * 15 * nights;
                    sport = "Volleyball";
                } else {
                    price = pupils * 20 * nights;
                    sport = "Swimming";
                }
        }
        if (pupils >= 50) {
            price *= 0.5;
        } else if (pupils >= 20 && pupils < 50) {
            price *= 0.85;
        } else if (pupils >= 10 && pupils < 20) {
            price *= 0.95;
        }
        System.out.printf("%s %.2f lv.", sport, price);
    }
}
