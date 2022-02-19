package FundamentalsLecture1;

import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            var m = i * 2 - 1;
            sum += m;
            System.out.println(m);
        }
        System.out.printf("Sum: %d", sum);
    }
}
