package MidExam;

import java.util.Scanner;

public class ProblemOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalPrice = 0.0;
        int orders = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < orders; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsuleCount = Integer.parseInt(scanner.nextLine());
            double coffeePrice = ((days * capsuleCount) * pricePerCapsule);
            totalPrice += coffeePrice;
            System.out.printf("The price for the coffee is: $%.2f\n", coffeePrice);
        }
        System.out.printf("Total: $%.2f", totalPrice);
    }
}
