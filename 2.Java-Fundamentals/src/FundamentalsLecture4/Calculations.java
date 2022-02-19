package FundamentalsLecture4;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        switch (command) {
            case "add":
                timeToAdd(n1, n2);
                break;
            case "divide":
                timeToDivide(n1, n2);
                break;
            case "multiply":
                timeToMultiply(n1, n2);
                break;
        }

    }

    private static void timeToMultiply(int n1, int n2) {
        System.out.println(n1 * n2);
    }

    private static void timeToDivide(int n1, int n2) {
        System.out.println(n1 / n2);
    }

    private static void timeToAdd(int n1, int n2) {
        System.out.println(n1 + n2);

    }
}
