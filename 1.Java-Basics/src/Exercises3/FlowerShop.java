package Exercises3;

import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int f1 = Integer.parseInt(scanner.nextLine());
        int f2 = Integer.parseInt(scanner.nextLine());
        int f3 = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holly = scanner.nextLine();
        double sum = 0.0;
        int all = f1 + f2 + f3;
        switch (season) {
            case "Spring":
            case "Summer":
                sum = f1 * 2 + f2 * 4.10 + f3 * 2.50;
                if (holly.equals("Y")) {
                    sum *= 1.15;
                }
                if (f3 > 7 && season.equals("Spring")) {
                    sum *= 0.95;
                }
                break;
            case "Autumn":
            case "Winter":
                sum = f1 * 3.75 + f2 * 4.50 + f3 * 4.15;
                if (holly.equals("Y")) {
                    sum *= 1.15;
                }
                if (f2 >= 10 && season.equals("Winter")) {
                    sum *= 0.9;
                }
        }
        if (all > 20) {
            sum *= 0.8;
        }
        System.out.printf("%.2f", sum + 2);
    }
}
