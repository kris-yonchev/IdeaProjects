package Lab4;

import java.util.Scanner;

public class Numbers11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        double maschine = Double.parseDouble(scanner.nextLine());
        int toy = Integer.parseInt(scanner.nextLine());
        int BrotherCut = 0;
        int cash = 0;
        int toyprice = 0;
        double sumMoney = 0.0;
        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                cash += 10;
                BrotherCut++;
                sumMoney = cash + sumMoney;
            } else {
                toyprice++;
            }
        }
        double c = sumMoney + (toy * toyprice) - BrotherCut;
        if (c >= maschine) {
            System.out.printf("Yes! %.2f", Math.abs(c - maschine));
        } else {
            System.out.printf("No! %.2f", Math.abs(maschine - c));
        }
    }
}
