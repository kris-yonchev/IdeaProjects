package Exercises3;

import java.util.Scanner;

public class TIR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String season = scanner.nextLine();
        double km = Double.parseDouble(scanner.nextLine());
        double price = 0.0;
        switch (season) {
            case "Spring":
            case "Autumn":
                if (km <= 5000) {
                    price = km * 0.75;
                } else if (km <= 10000) {
                    price = km * 0.95;
                }
                break;
            case "Summer":
                if (km <= 5000) {
                    price = km * 0.90;
                } else if (km <= 10000) {
                    price = km * 1.10;
                }
                break;
            case "Winter":
                if (km <= 5000) {
                    price = km * 1.05;
                } else if (km <= 10000) {
                    price = km * 1.25;
                }
        }
        if (km <= 20000 && km > 10000) {
            price = km * 1.45;
        }
        price = (price * 4) * 0.9;
        System.out.printf("%.2f", price);
    }
}
