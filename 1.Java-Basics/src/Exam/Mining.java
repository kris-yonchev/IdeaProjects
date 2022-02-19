package Exam;

import java.util.Scanner;

public class Mining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int locations = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= locations; i++) {
            double average = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            double oro = 0.0;
            for (int j = 1; j <= days; j++) {
                double goldPerDay = Double.parseDouble(scanner.nextLine());
                oro += goldPerDay;

            }

            double averageOro = oro / days;
            if (averageOro >= average) {
                System.out.printf("Good job! Average gold per day: %.2f.\n", averageOro );
            } else {
                System.out.printf("You need %.2f gold.\n", Math.abs(average-averageOro));
            }
        }
    }
}
