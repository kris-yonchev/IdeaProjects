package Exercise4;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int amount = 0;
        int price1 = 0;
        int price2 = 0;
        int price3 = 0;
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            amount += number;
            if (number <= 3) {
                price1 += number;
            } else if (number <= 11) {
                price2 += number;
            } else if (number >= 12) {
                price3 += number;
            }
        }
        sum = 1.0 * (price1 * 200 + price2 * 175 + price3 * 120) / amount;
        double bus = (double) price1 / amount * 100;
        double truck = (double) price2 / amount * 100;
        double train = (double) price3 / amount * 100;
        System.out.printf("%.2f\n%.2f%%\n%.2f%%\n%.2f%%", sum, bus, truck, train);
    }
}
