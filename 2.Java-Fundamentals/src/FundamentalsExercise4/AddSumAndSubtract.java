package FundamentalsExercise4;

import java.util.Scanner;

public class AddSumAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        System.out.println(findSum(n1, n2, n3));

    }



    private static int findSum(int n1, int n2, int n3) {
        return (n1 + n2) - n3;

    }
}
