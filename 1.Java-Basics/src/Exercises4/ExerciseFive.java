package Exercise4;

import java.util.Scanner;

public class ExerciseFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double p1 = 0.0;
        double p2 = 0.0;
        double p3 = 0.0;
        double count1 = 0.0;
        double count2 = 0.0;
        double count3 = 0.0;
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number % 2 == 0) {
                count1++;
                p1 = (count1 / n) * 100;
            }
            if (number % 3 == 0) {
                count2++;
                p2 = count2 / n * 100;
            }
            if (number % 4 == 0) {
                count3++;
                p3 = count3 / n * 100;
            }
        }
        System.out.printf("%.2f%%\n%.2f%%\n%.2f%%", p1, p2, p3);
    }
}
