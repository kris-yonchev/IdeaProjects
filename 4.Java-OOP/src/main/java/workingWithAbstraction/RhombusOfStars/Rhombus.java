package workingWithAbstraction.RhombusOfStars;

import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int starCount = 1; starCount <= n; starCount++) {
            printRow(n, starCount);
        }

        for (int starCount = n - 1; starCount >= 1; starCount--) {
            printRow(n, starCount);
        }

    }

    private static void printRow(int size, int count) {
        for (int i = 0; i < size - count; i++) {
            System.out.print(" ");
        }
        for (int col = 1; col <= count; col++) {
            System.out.print("* ");
        }
        System.out.println();
    }

}
