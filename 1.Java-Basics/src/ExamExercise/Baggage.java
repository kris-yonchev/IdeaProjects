package ExamExercise;

import java.util.Scanner;

public class Baggage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double twenty = Double.parseDouble(scanner.nextLine());
        double kg = Double.parseDouble(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int bags = Integer.parseInt(scanner.nextLine());
        double price = 0.0;
        if (kg <= 20 && kg>=10) {
            price = twenty * 0.5;
        } else if (kg<=10) {
            price = twenty * 0.2;
        } else if (kg > 20) {
            price = twenty;
        }
        if (days > 30) {
            price += price * 0.1;
        } else if (days >= 7) {
            price += price * 0.15;
        } else if (days < 7) {
            price += price * 0.4;
        }
        System.out.printf("The total price of bags is: %.2f lv.\n", price * bags);
    }
}
