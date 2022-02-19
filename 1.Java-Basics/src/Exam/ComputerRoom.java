package Exam;

import java.util.Scanner;

public class ComputerRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int hours = Integer.parseInt(scanner.nextLine());
        int people = Integer.parseInt(scanner.nextLine());
        String day = scanner.nextLine();
        double sum = 0.0;
        double price = 0.0;
        switch (month) {
            case "march":
            case "april":
            case "may":
                if (day.equals("day")) {
                    price = 10.50 ;
                } else {
                    price = 8.40 ;
                }
                break;
            case "june":
            case "july":
            case "august":
                if (day.equals("day")) {
                    price = 12.60 ;
                } else {
                    price = 10.20 ;
                }
                break;
        }
        if (people >= 4) {
            price *= 0.9;
        }
        if (hours >= 5) {
            price *= 0.5;
        }
        System.out.printf("Price per person for one hour: %.2f\nTotal cost of the visit: %.2f", price, (price*people)*hours);
    }
}
