package Exam;

import java.util.Scanner;

public class FinalComp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dancers = Integer.parseInt(scanner.nextLine());
        double points = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String place = scanner.nextLine();
        double prizemoney = points * dancers;
        double expenses = 0.0;
        switch (place) {
            case "Bulgaria":
                if (season.equals("summer")) {
                    expenses = 0.95;
                } else {
                    expenses = 0.92;
                }
                break;
            case "Abroad":
                prizemoney += prizemoney * 0.5;
                if (season.equals("summer")) {
                    expenses = 0.9;
                } else {
                    expenses = 0.85;
                }
        }
        prizemoney *= expenses;
        double charitymoney = prizemoney * 0.75;
        prizemoney *= 0.25;
        double moneyperdancer = prizemoney / dancers;
        System.out.printf("Charity - %.2f\nMoney per dancer - %.2f", charitymoney, moneyperdancer);
    }
}
