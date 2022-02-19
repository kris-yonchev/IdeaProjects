package Lab6;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String destination = input;
            double budget = Double.parseDouble(scanner.nextLine());
            double money = 0;
            while (money < budget) {
                double number = Double.parseDouble(scanner.nextLine());
                money += number;
            }
            System.out.printf("Going to %s!\n", destination);
            input = scanner.nextLine();
        }

    }
}



