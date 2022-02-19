package FundamentalsLecture1;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        do {
            int result = n * m;
            System.out.printf("%d X %d = %d\n", n, m, result);
            m++;
        } while (m <= 10);
    }
}
