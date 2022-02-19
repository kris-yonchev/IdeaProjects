package FundamentalsMoreExercises3;

import java.util.Scanner;

public class BibonaciDos {
    static int fib(int n) {

        int[] f = new int[n + 2];
        int i;


        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++) {

            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(fib(n));
    }
}