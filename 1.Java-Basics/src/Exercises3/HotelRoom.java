package Exercises3;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int stay = Integer.parseInt(scanner.nextLine());
        double price1 = 0.0;
        double price2 = 0.0;
        if (month.equals("May") || month.equals("October")) {
            price1 = 50 * stay;
            price2 = 65 * stay;
            if (stay > 7 && stay <= 14) {
                price1 *= 0.95;
            } else if (stay > 14) {
                price1 *= 0.7;
                price2 *= 0.9;
            }
        } else if (month.equals("June") || month.equals("September")) {
            price1 = 75.20 * stay;
            price2 = 68.70 * stay;
            if (stay > 14) {
                price1 *= 0.8;
                price2 *= 0.9;
            }
        } else if (month.equals("July") || month.equals("August")) {
            price1 = 76 * stay;
            price2 = 77 * stay;
            if (stay > 14) {
                price2 *= 0.9;
            }
        }
        System.out.printf("Apartment: %.2f lv.\nStudio: %.2f lv.", price2, price1);
    }
}
