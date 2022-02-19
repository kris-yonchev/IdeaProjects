package Exercises;

import java.util.Scanner;

public class kuchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int bakers = Integer.parseInt(scanner.nextLine());
        int cakes = Integer.parseInt(scanner.nextLine());
        int waffles = Integer.parseInt(scanner.nextLine());
        int pans = Integer.parseInt(scanner.nextLine());
        int sum1 = cakes * 45;
        double sum2 = waffles * 5.80;
        double sum3 = pans * 3.20;
        double all = (sum1 + sum2 + sum3) * bakers;
        double campaign = all * days;
        System.out.printf("%.2f", campaign - (campaign / 8));
    }
}
