package Exercises2;

import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int flower1 = Integer.parseInt(scanner.nextLine());
        int flower2 = Integer.parseInt(scanner.nextLine());
        int flower3 = Integer.parseInt(scanner.nextLine());
        int flower4 = Integer.parseInt(scanner.nextLine());
        double gift = Double.parseDouble(scanner.nextLine());
        double ordersumm = (flower1 * 3.25)+(flower2*4)+(flower3*3.5)+(flower4*8);
        double taxes = ordersumm * 0.05;
        double moneyleft = ordersumm - taxes;
        if (moneyleft>=gift){
            double diff = Math.floor(moneyleft - gift);
            System.out.printf("She is left with %.0f leva.", diff);
        } else {
            double diff = Math.ceil(gift - moneyleft);
            System.out.printf("She will have to borrow %.0f leva.", diff);
        }
    }
}
