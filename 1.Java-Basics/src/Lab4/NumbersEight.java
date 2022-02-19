package Lab4;

import java.util.Scanner;

public class NumbersEight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int maxn = Integer.MIN_VALUE;
        int minn = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (maxn < number) {
                maxn = number;
            }
            if (number < minn) {
                minn = number;
            }

        }
        System.out.printf("Max number: %d\nMin number: %d", maxn, minn);
    }
}
