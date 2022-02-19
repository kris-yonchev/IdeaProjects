package Exam;

import java.util.Scanner;

public class ComputerFirm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double rate = 0;
        String sales = "";
        double sales1 = 0;
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            int rating = number % 10;
            rate += rating;
            int n1 = (number / 100) % 10;
            int n2 = (number / 10) % 10;
            sales = "" + n1 + n2;
            double pray = Double.parseDouble(sales);
            switch (rating) {
                case 3:
                    sales1 += pray * 0.5;
                    break;
                case 4:
                    sales1 += pray * 0.7;
                    break;
                case 5:
                    sales1 += pray * 0.85;
                    break;
                case 6:
                    sales1 += pray;
                    break;
                case 2:
                    sales1 += 0;
                    break;

            }
        }
        System.out.printf("%.2f\n%.2f", sales1, rate / n);
    }
}
