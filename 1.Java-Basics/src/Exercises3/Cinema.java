package Exercises3;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        double sum = 0.00;
        if (type.equals("Premiere")) {
            sum = (r * c) * 12;
        } else if (type.equals("Normal")) {
            sum = (r * c) * 7.50;
        } else if (type.equals("Discount")) {
            sum = (r * c) * 5;
        }
        System.out.printf("%.2f", sum);

    }
}
