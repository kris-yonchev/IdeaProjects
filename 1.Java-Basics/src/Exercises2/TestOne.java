package Exercises2;

import java.util.Scanner;

public class TestOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bitcoin = Integer.parseInt(scanner.nextLine());
        double yuan = Double.parseDouble(scanner.nextLine());
        double comision = Double.parseDouble(scanner.nextLine());

        int bitcointpr = bitcoin * 1168;
        double yuanusd = yuan * 0.15;
        double yuanbgn = yuanusd * 1.76;
        double price = yuanbgn + bitcointpr;
        double euprice = price * 0.51282051282;
        double finalprice = euprice - (euprice * (comision/100));
        System.out.printf("%.2f", finalprice);
    }
}
