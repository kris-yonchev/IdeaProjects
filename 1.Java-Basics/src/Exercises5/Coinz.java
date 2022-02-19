package Exercises5;

import java.util.Scanner;

public class Coinz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double change = Double.parseDouble(scanner.nextLine());
        int coincount = 0;
        change *= 100;
        while (change > 0.0) {
            if (change >= 200) {
                change -= 200;
                coincount++;
            } else if (change >= 100) {
                change -= 100;
                coincount++;
            } else if (change >= 50) {
                change -= 50;
                coincount++;
            } else if (change >= 20) {
                change -= 20;
                coincount++;
            } else if (change >= 10) {
                change -= 10;
                coincount++;
            } else if (change >= 5) {
                change -= 5;
                coincount++;
            } else if (change >= 2) {
                change -= 2;
                coincount++;
            } else if (change >= 1) {
                change -= 1;
                coincount++;
            } else {
                break;
            }
        }
        System.out.printf("%d", coincount);
    }
}
