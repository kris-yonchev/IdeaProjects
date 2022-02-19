package Exercise4;

import java.util.Scanner;

public class GoT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double sum = 0;
        double v1 = 0;
        double v2 = 0;
        double v3 = 0;
        double v4 = 0;
        double v5 = 0;
        double invalid = 0;
        for (int i = 1; i <= n; i++) {
            double turns = Double.parseDouble(scanner.nextLine());
            if (turns < 0 || turns > 50) {
                invalid++;
                sum /= 2;
            } else if (turns <= 9) {
                v1++;
                sum += turns * 0.2;
            } else if (turns <= 19) {
                v2++;
                sum += turns * 0.3;
            } else if (turns <= 29) {
                v3++;
                sum += turns * 0.4;
            } else if (turns <= 39) {
                v4++;
                sum += 50;
            } else if (turns <= 50) {
                v5++;
                sum += 100;
            }
        }
        v1 = v1 / n * 100;
        v2 = v2 / n * 100;
        v3 = v3 / n * 100;
        v4 = v4 / n * 100;
        v5 = v5 / n * 100;
        invalid = invalid / n * 100;
        System.out.printf("%.2f\nFrom 0 to 9: %.2f%%\nFrom 10 to 19: %.2f%%\nFrom 20 to 29: %.2f%%\nFrom 30 to 39: %.2f%%\nFrom 40 to 50: %.2f%%\nInvalid numbers: %.2f%%", sum, v1, v2, v3, v4, v5, invalid);
    }
}
