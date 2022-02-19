package workingWithAbstraction.hotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] data = scanner.nextLine().split(" ");

        double pricePerDay = Double.parseDouble(data[0]);
        int numberOfDays = Integer.parseInt(data[1]);
        String season = data[2];
        String discountType = data[3];

        double result = PriceCalculator.CalculatePrice(pricePerDay, numberOfDays, Season.valueOf(season), Discount.valueOf(discountType));
        System.out.printf("%.2f", result);
    }
}
