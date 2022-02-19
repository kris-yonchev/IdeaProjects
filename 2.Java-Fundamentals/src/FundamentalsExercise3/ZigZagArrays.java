package FundamentalsExercise3;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arrayOne = new int[n];
        int[] arrayTwo = new int[n];

        for (int i = 1; i <= n; i++) {
            String[] numbers = scanner.nextLine().split(" ");
                if (i%2==0) {
                    arrayOne[i-1] = Integer.parseInt(numbers[1]);
                    arrayTwo[i-1] = Integer.parseInt(numbers[0]);
                } else {
                    arrayOne[i-1] = Integer.parseInt(numbers[0]);
                    arrayTwo[i-1] = Integer.parseInt(numbers[1]);
                }

        }
        for (int k : arrayOne) {
            System.out.print(k + " ");
        }
        System.out.println();
        for (int j : arrayTwo) {
            System.out.print(j + " ");

        }

    }
}
