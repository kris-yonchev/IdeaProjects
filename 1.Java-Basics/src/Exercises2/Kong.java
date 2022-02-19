package Exercises2;

import java.util.Scanner;

public class Kong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int statistics = Integer.parseInt(scanner.nextLine());
        double clothingforone = Double.parseDouble(scanner.nextLine());
        double sumdecor = budget * 0.1;
        double sumclothing = statistics * clothingforone;
        if (statistics>=150){
            sumclothing = sumclothing - (0.1 * sumclothing);
        }  double totalsum = sumclothing + sumdecor;
        if (totalsum<=budget){
            double moneyleft = budget - totalsum;
            System.out.printf("Action!\nWingard starts filming with %.2f leva left.", moneyleft);
        } else if (totalsum>budget){
            double moneyneeded = Math.abs(budget-totalsum);
            System.out.printf("Not enough money!\nWingard needs %.2f leva more.", moneyneeded);
        }

    }
}
