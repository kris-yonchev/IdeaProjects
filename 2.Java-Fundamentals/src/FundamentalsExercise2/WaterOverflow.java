package FundamentalsExercise2;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int currentCapacity = 0;
        for (int i = 1; i <= n; i++) {
            int liters = Integer.parseInt(scanner.nextLine());
            currentCapacity += liters;
            if (currentCapacity > 255) {
                System.out.println("Insufficient capacity!");
                currentCapacity -= liters;
            }


        }
        System.out.println(currentCapacity);
    }
}
