package Exercise4;

import java.util.Scanner;

public class Hexogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = Double.parseDouble(scanner.nextLine());
        double p1 = 0.0;
        double p2 = 0.0;
        double p3 = 0.0;
        double p4 = 0.0;
        double p5 = 0.0;
        double count1 = 0.0;
        double count2 = 0.0;
        double count3 = 0.0;
        double count4 = 0.0;
        double count5 = 0.0;
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 200) {
                count1++;
                p1 = (count1 / n) * 100;
            } else if (number <= 399) {
                count2++;
                p2 = (count2 / n) * 100;
            } else if (number <= 599) {
                count3++;
                p3 = (count3 / n) * 100;
            } else if (number <= 799) {
                count4++;
                p4 = (count4 / n) * 100;
            } else if (number >= 800) {
                count5++;
                p5 = (count5 / n) * 100;
            }

        }
        System.out.printf("%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%\n%.2f%%", p1, p2, p3, p4, p5);
    }
}
