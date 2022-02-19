package Exercise6;

import java.util.Scanner;

public class HappyCatParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());
        double totalsum = 0.0;
        for (int i = 1; i <= days; i++) {
            double daysum = 0.0;
            for (int j = 1; j <= hours; j++) {
                double price = 0.0;
                if (i % 2 == 0 && j % 2 != 0) {
                    price = 2.50;
                } else if (i % 2 != 0 && j % 2 == 0) {
                    price = 1.25;
                } else {
                    price = 1;
                }
                daysum += price;
                totalsum += price;
            }
            System.out.printf("Day: %d - %.2f leva\n", i, daysum);
        }
        System.out.printf("Total: %.2f leva", totalsum);
    }
}
