package Lab3;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stay = Integer.parseInt(scanner.nextLine()) - 1;
        String type = scanner.nextLine();
        String answer = scanner.nextLine();
        double price = 0.0;

        if (type.equals("room for one person")) {
            price = stay * 18;
        } else if (type.equals("apartment")) {
            price = stay * 25;
            if (stay < 10) {
                price = price - (price * 0.3);
            } else if (stay >= 10 && stay <= 15) {
                price = price - (price * 0.35);
            } else if (stay > 15) {
                price = price - (price * 0.50);
            }

        } else if (type.equals("president apartment")) {
            price = stay * 35;
            if (stay < 10) {
                price = price - (price - 0.1);
            } else if (stay >= 10 && stay <= 15) {
                price = price - (price * 0.15);
            } else if (stay > 15) {
                price = price - (price * 0.2);
            }
        }
        if (answer.equals("positive")) {
            price = price + (price * 0.25);
        } else if (answer.equals("negative")) {
            price = price - (price * 0.1);
        }
        System.out.printf("%.2f", price);

    }
}
