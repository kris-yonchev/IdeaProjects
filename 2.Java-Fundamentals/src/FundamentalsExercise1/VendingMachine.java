package FundamentalsExercise1;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0.0;
        String input = scanner.nextLine();
        while (!input.equals("Start")) {
            double coins = Double.parseDouble(input);
            if (coins != 0.1 && coins != 0.2 && coins != 0.5 && coins != 1 && coins != 2) {
                System.out.printf("Cannot accept %.2f\n", coins);
            } else {
                sum += coins;
            }
            input = scanner.nextLine();
        }
        while (!input.equals("End")) {
            input = scanner.nextLine();
            if (input.equals("End")) {
                break;
            }
            double price = 0.0;
            switch (input) {
                case "Nuts":
                    price = 2;
                    if (price > sum) {
                        System.out.println("Sorry, not enough money");
                        continue;
                    }
                    sum -= price;
                    System.out.println("Purchased Nuts");
                    break;
                case "Water":
                    price = 0.7;
                    if (price > sum) {
                        System.out.println("Sorry, not enough money");
                        continue;
                    }
                    sum -= price;
                    System.out.println("Purchased Water");
                    break;
                case "Crisps":
                    price = 1.5;
                    if (price > sum) {
                        System.out.println("Sorry, not enough money");
                        continue;
                    }
                    sum -= price;
                    System.out.println("Purchased Crisps");
                    break;
                case "Soda":
                    price = 0.8;
                    if (price > sum) {
                        System.out.println("Sorry, not enough money");
                        continue;
                    }
                    sum -= price;
                    System.out.println("Purchased Soda");
                    break;
                case "Coke":
                    price = 1.0;
                    if (price > sum) {
                        System.out.println("Sorry, not enough money");
                        continue;
                    }
                    sum -= price;
                    System.out.println("Purchased Coke");
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
        }
        System.out.printf("Change: %.2f", sum);

    }
}
