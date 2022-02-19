package FundamentalsExercise4;

import java.util.Scanner;

public class SmallestInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        System.out.println(getSmallestInt(n1, n2, n3));
    }

    private static int getSmallestInt(int n1, int n2, int n3) {
        return Integer.min(n1, Integer.min(n2, n3));
    }
}
