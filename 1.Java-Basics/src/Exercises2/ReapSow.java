package Exercises2;

import java.util.Scanner;

public class ReapSow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double X = Double.parseDouble(scanner.nextLine());
        double Y = Double.parseDouble(scanner.nextLine());
        double Z = Double.parseDouble(scanner.nextLine());
        int W = Integer.parseInt(scanner.nextLine());
        double grapes = X * Y;
        double wineliters = (grapes * 0.40) / 2.50;
        double difference = -1;
        double litersPerWorker = - 1;
        if (wineliters>= Z) {
            difference = wineliters - Z;
            litersPerWorker = Math.ceil(difference/W);
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", Math.floor(wineliters));
            System.out.printf("%.0f liters left -> %.0f liters per person.", difference, litersPerWorker);
        } else {
            difference= Math.floor(Z - wineliters);
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", difference);
        }


    }
}
