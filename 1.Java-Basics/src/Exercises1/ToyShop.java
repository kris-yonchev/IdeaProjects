package Exercises;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double prvacation = Double.parseDouble(scanner.nextLine());
        int jigsaws = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int bears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        double orderamount = jigsaws + dolls + bears + minions + trucks;
        double ordersumm = (jigsaws * 2.60) + (dolls * 3) + (bears * 4.10) + (minions * 8.20) + (trucks * 2);
        if (orderamount >= 50) {
            ordersumm = ordersumm - (0.25 * ordersumm);
        }
        double naem = ordersumm * 0.1;
        ordersumm = ordersumm - naem;
        if (ordersumm >= prvacation) {
            var moneyleft = ordersumm - prvacation;
            System.out.printf("Yes! " + "%.2f" + " lv left.", moneyleft);
        } else {
            var moneyreq = prvacation - ordersumm;
            System.out.printf("Not enough money! " + "%.2f" + " lv needed.", moneyreq);

        }
    }
}
