package Exercises5;

import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int detergent = Integer.parseInt(scanner.nextLine());
        int totaldetergent = 750 * detergent;
        int i = 0;
        int pots = 0;
        int dishes = 0;
        boolean finished = false;
        while (totaldetergent >= 0) {
            String pepega = scanner.nextLine();
            if (pepega.equals("End")) {
                finished = true;
                break;
            }
            int number = Integer.parseInt(pepega);
            i++;
            if (i % 3 == 0) {
                totaldetergent -= 15 * number;
                pots+=number;
            } else {
                totaldetergent -= 5 * number;
                dishes+=number;
            }
            if (totaldetergent < 0) {
                break;
            }
        }
        if (finished) {
            System.out.printf("Detergent was enough!\n" +
                    "%d dishes and %d pots were washed.\n" +
                    "Leftover detergent %d ml.\n", dishes, pots, totaldetergent);
        } else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(totaldetergent));
        }
    }
}
