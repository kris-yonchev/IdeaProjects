package Exercise4;

import java.util.Scanner;

public class Equalpairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int lastValue = 0;
        int Diff = 0;

        for (int i = 1; i <= n; i++) {
            int number1 = Integer.parseInt(scanner.nextLine());
            int number2 = Integer.parseInt(scanner.nextLine());
            int sum = number1 + number2;
            if (i>1) {
                Diff = Math.abs(lastValue-sum);
            } lastValue = sum;
        } if (Diff==0) {
            System.out.printf("Yes, value=%d", lastValue);
        } else {
            System.out.printf("No, maxdiff=%d",Diff);
        }
    }
}