package FundamentalsExercise1;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = Double.parseDouble(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0.0;
        switch (day) {
            case "Friday":
                if (type.equals("Students")) {
                    price = 8.45;
                    if (number >= 30) {
                        price *= 0.85;
                    }
                } else if (type.equals("Business")) {
                    price = 10.90;
                    if (number >= 100) {
                        number -= 10;
                    }
                } else if (type.equals("Regular")) {
                    price = 15;
                    if (number >= 10 && number <= 20) {
                        price *= 0.95;
                    }
                }
                break;
            case "Saturday":
                if (type.equals("Students")) {
                    price = 9.80;
                    if (number >= 30) {
                        price *= 0.85;
                    }
                } else if (type.equals("Business")) {
                    price = 15.60;
                    if (number >= 100) {
                        number -= 10;
                    }
                } else if (type.equals("Regular")) {
                    price = 20;
                    if (number >= 10 && number <= 20) {
                        price *= 0.95;
                    }
                }
                break;
            case "Sunday":
                if (type.equals("Students")) {
                    price = 10.46;
                    if (number >= 30) {
                        price *= 0.85;
                    }
                } else if (type.equals("Business")) {
                    price = 16;
                    if (number >= 100) {
                        number -= 10;
                    }
                } else if (type.equals("Regular")) {
                    price = 22.50;
                    if (number >= 10 && number <= 20) {
                        price *= 0.95;
                    }
                }
                break;
        }
        var total = number * price;
        System.out.printf("Total price: %.2f", total);
    }
}
