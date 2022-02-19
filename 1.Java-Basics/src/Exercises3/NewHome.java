package Exercises3;

import java.util.Scanner;

public class NewHome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        int amount = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double sum = 0.00;
        if (type.equals("Roses")) {
            sum = amount * 5;
            if (amount > 80) {
                sum = sum - (sum * 0.1);
            }
        } else if (type.equals("Dahlias")) {
            sum = amount * 3.80;
            if (amount > 90) {
                sum = sum - (sum * 0.15);
            }
        } else if (type.equals("Tulips")) {
            sum = amount * 2.80;
            if (amount > 80) {
                sum = sum - (sum * 0.15);
            }
        } else if (type.equals("Narcissus")) {
            sum = amount * 3;
            if (amount < 120) {
                sum = sum + (sum * 0.15);
            }
        } else if (type.equals("Gladiolus")) {
            sum = amount * 2.50;
            if (amount < 80) {
                sum = sum + (sum * 0.20);
            }
        }
        double surplus = Math.abs(budget-sum);
        if (budget >= sum) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", amount, type, surplus);
        } else if (budget<sum){
            System.out.printf("Not enough money, you need %.2f leva more.", surplus);

        }
    }
}
