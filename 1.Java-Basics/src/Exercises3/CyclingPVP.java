package Exercises3;

import java.util.Scanner;

public class CyclingPVP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int junior = Integer.parseInt(scanner.nextLine());
        int senior = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        int all = junior + senior;
        double sum = 0.0;
        switch (type) {
            case "trail":
                sum = junior * 5.50 + senior * 7;
                break;
            case "cross-country":
                if (all >= 50) {
                    sum = (junior * 8 + senior * 9.50) * 0.75;
                } else {
                    sum = junior * 8 + senior * 9.50;
                }
                break;
            case "downhill":
                sum = junior * 12.25 + senior * 13.75;
                break;
            case "road":
                sum = junior * 20 + senior * 21.50;
                break;
        }
        System.out.printf("%.2f", sum * 0.95);
    }
}
