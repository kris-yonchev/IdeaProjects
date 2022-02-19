package FundamentalsLecture4;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        triangleHeight(length);
        printSingleLine(length);
        printBottom(length);
    }


    private static void printSingleLine(int height) {
        for (int i = 1; i <= height; i++) {

            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void triangleHeight(int length) {
        for (int i = 1; i < length; i++) {
            printSingleLine(i);
        }
    }

    private static void printBottom(int length) {
        for (int i = length - 1; i >= 1; i--) {
            printSingleLine(i);
        }
    }


}
