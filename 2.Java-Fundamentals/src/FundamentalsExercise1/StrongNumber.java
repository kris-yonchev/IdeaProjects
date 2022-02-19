package FundamentalsExercise1;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String m = Integer.toString(n);
        int total = 0;
        for (int i = 0; i < m.length(); i++) {
            int factorial = 1;
            char x = m.charAt(i);
            int a = Character.getNumericValue(x);

            for (int j = 1; j <= a; j++) {
                factorial *= j;

            }
            total += factorial;
        }
        if (total == n) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
