package Exercises2;

import java.util.Scanner;

public class ReapSow2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double vineyardSqM = Double.parseDouble(console.nextLine());
        double harvestedGrapesBySqM = Double.parseDouble(console.nextLine());
        double necessaryLitersWineProduction = Double.parseDouble(console.nextLine());
        int numberOfWorkers = Integer.parseInt(console.nextLine());

        double harvest = vineyardSqM * harvestedGrapesBySqM;
        harvest *= 0.40;
        double producedLitersOfWine = harvest / 2.50;

        if (producedLitersOfWine >= necessaryLitersWineProduction) {
            System.out.printf("Good harvest this year! Total wine: " +
                    "%d liters.%n", (int)Math.floor(producedLitersOfWine));
            System.out.printf("%d liters left -> %d liters per person.",
                    (int)Math.ceil(producedLitersOfWine - necessaryLitersWineProduction),
                    (int)Math.ceil((producedLitersOfWine - necessaryLitersWineProduction)
                            / numberOfWorkers));
        } else {
            System.out.printf("It will be a tough winter! More " +
                            "%d liters wine needed.",
                    (int)Math.floor(necessaryLitersWineProduction - producedLitersOfWine));
        }
    }
}