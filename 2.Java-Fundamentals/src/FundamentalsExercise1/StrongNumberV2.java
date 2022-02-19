package FundamentalsExercise1;

import java.util.Scanner;

public class StrongNumberV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int ogNumber = n;
        int total = 0;
        while (n!=0) {
            int number = n % 10;
            int fact = 1;
            for (int i = 1; i <= number; i++) {

                fact *= i;

            }
            total += fact;
            n = n / 10;
        }
        if (total==ogNumber) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
