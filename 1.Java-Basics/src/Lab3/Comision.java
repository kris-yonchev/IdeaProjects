package Lab3;

import java.util.Scanner;

public class Comision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        double volume = Double.parseDouble(scanner.nextLine());
        double sales = 0.00;
        if (volume < 0) {
            System.out.println("error");
        } else if (city.equals("Sofia")) {
            if (volume >= 0 && volume <= 500) {
                volume *= 0.05;
            } else if (volume > 500 && volume <= 1000) {
                volume *= 0.07;
            } else if (volume > 1000 && volume <= 10000) {
                volume *= 0.08;
            } else if (volume > 10000) {
                volume *= 0.12;
            }
            System.out.printf("%.2f", volume);
        } else if (city.equals("Varna")) {
            if (volume >= 0 && volume <= 500) {
                volume *= 0.045;
            } else if (volume > 500 && volume <= 1000) {
                volume *= 0.075;
            } else if (volume > 1000 && volume <= 10000) {
                volume *= 0.1;
            } else if (volume > 10000) {
                volume *= 0.13;
            }
            System.out.printf("%.2f", volume);
        } else if (city.equals("Plovdiv")) {
            if (volume >= 0 && volume <= 500) {
                volume *= 0.055;
            } else if (volume > 500 && volume <= 1000) {
                volume *= 0.08;
            } else if (volume > 1000 && volume <= 10000) {
                volume *= 0.12;
            } else if (volume > 10000) {
                volume *= 0.145;
            }
            System.out.printf("%.2f", volume);

        } else {
            System.out.println("error");
        }
    }
}
