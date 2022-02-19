package Exercises5;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amount = Double.parseDouble(scanner.nextLine());
        double money = Double.parseDouble(scanner.nextLine());
        int dayscounter = 0;
        int spendcouter = 0;

        while (money < amount && spendcouter < 5) {
            String action = scanner.nextLine();
            double saving = Double.parseDouble(scanner.nextLine());
            dayscounter++;
            if (action.equals("spend")) {
                money -= saving;
                spendcouter++;
                if (money < 0) {
                    money = 0;
                }
            } else if (action.equals("save")) {
                spendcouter=0;
                money += saving;
            }

        }
        if (spendcouter == 5) {
            System.out.printf("You can't save the money.\n%d", dayscounter);
        } else if (money >= amount) {
            System.out.printf("You saved the money for %d days.", dayscounter);
        }
    }
}
