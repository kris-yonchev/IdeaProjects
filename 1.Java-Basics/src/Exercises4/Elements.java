package Exercise4;

import java.util.Scanner;

public class Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int maxn = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number > maxn) {
                maxn = number;
            }
            sum += number;
        }
        int sumwithoutmax = sum - maxn;
        if (maxn == sumwithoutmax ) {
            System.out.printf("Yes\nSum = %d", maxn);
        } else {
            System.out.printf("No\nDiff = %d", Math.abs(maxn - sumwithoutmax));
        }
    }
}
