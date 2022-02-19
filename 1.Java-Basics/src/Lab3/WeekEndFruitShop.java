package Lab3;

import java.util.Scanner;

public class WeekEndFruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double amount = Double.parseDouble(scanner.nextLine());
        double price = 0.00;
        var stopops = 0;
        if (day.equals("Saturday") || day.equals("Sunday")) {
            switch (fruit) {
                case "banana":
                    price = 2.70 * amount;
                    break;
                case "apple":
                    price = 1.25 * amount;
                    break;
                case "orange":
                    price = 0.90 * amount;
                    break;
                case "grapefruit":
                    price = 1.60 * amount;
                    break;
                case "kiwi":
                    price = 3.00 * amount;
                    break;
                case "pineapple":
                    price = 5.60 * amount;
                    break;
                case "grapes":
                    price = 4.20 * amount;
                    break;
            }
        } else if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") ||
                day.equals("Thursday") || day.equals("Friday")) {
            switch (fruit) {
                case "banana":
                    price = 2.50 * amount;
                    break;
                case "apple":
                    price = 1.20 * amount;
                    break;
                case "orange":
                    price = 0.85 * amount;
                    break;
                case "grapefruit":
                    price = 1.45 * amount;
                    break;
                case "kiwi":
                    price = 2.70 * amount;
                    break;
                case "pineapple":
                    price = 5.50 * amount;
                    break;
                case "grapes":
                    price = 3.85 * amount;
                    break;

            }


        }
        if (price != 0.0) {
            System.out.printf("%.2f", price);
        } else {
            System.out.printf("error");
        }
    }
}
