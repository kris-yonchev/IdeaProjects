package Lab5;

import java.util.Scanner;

public class MoneyInDaBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double sum = 0.0;
        while (!input.equals("NoMoreMoney")) {
            double number = Double.parseDouble(input);
            if (number < 0) {
                System.out.println("Invalid operation!");
                break;
            }
            sum += number;
            System.out.printf("Increase: %.2f\n", number);
            input = scanner.nextLine();

        }
        System.out.printf("Total: %.2f", sum);
    }
}
