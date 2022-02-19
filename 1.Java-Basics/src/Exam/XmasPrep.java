package Exam;

import java.util.Scanner;

public class XmasPrep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rolls = Integer.parseInt(scanner.nextLine());
        int cloth = Integer.parseInt(scanner.nextLine());
        double glue = Double.parseDouble(scanner.nextLine());
        double discount = Double.parseDouble(scanner.nextLine()) / 100;
        double rollsPrice = rolls * 5.80;
        double clothPrice = cloth * 7.20;
        double gluePrice = glue * 1.20;
        double sum = gluePrice + clothPrice + rollsPrice;
        double exit = sum - (sum * discount);
        System.out.printf("%.3f", exit);
    }
}
