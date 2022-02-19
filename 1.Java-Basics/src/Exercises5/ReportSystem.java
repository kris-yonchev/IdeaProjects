package Exercises5;

import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int soldcountk = 0;
        int soldcountc = 0;
        double credit = 0;
        double cash = 0;
        int i = 0;
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            int number = Integer.parseInt(input);
            i++;
            if (i % 2 != 0) {
                if (number > 100) {
                    System.out.printf("Error in transaction!\n");
                } else {
                    System.out.printf("Product sold!\n");
                    sum += number;
                    soldcountc++;
                    cash += number;
                }
            } else {
                if (number < 10) {
                    System.out.printf("Error in transaction!\n");
                } else {
                    System.out.printf("Product sold!\n");
                    sum += number;
                    soldcountk++;
                    credit += number;
                }
            }
            if (sum >= amount) {
                break;
            }
            input = scanner.nextLine();
        }
        if (sum < amount) {
            System.out.println("Failed to collect required money for charity.");
        } else {
            System.out.printf("Average CS: %.2f\n" +
                    "Average CC: %.2f\n", cash / soldcountc, credit / soldcountk);
        }
    }
}
