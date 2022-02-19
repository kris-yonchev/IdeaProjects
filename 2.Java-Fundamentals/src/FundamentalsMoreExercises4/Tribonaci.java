package FundamentalsMoreExercises4;

import java.util.Scanner;

public class Tribonaci {
    static void fib(int n) {

        int[] f = new int[n];
        switch (n) {
            case 1:
                f[0] = 1;
                break;
            case 2:
                f[0] = 1;
                f[1] = 1;
                break;
            default:
                f[0] = 1;
                f[1] = 1;
                f[2] = 2;
        }

        int i;
        for (i = 3; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2] + f[i - 3];
        }
        for (int j = 0; j < n; j++) {
            System.out.print(f[j] + " ");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        fib(n);

    }

}
