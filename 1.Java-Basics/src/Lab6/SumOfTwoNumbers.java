package Lab6;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int magic = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int n1 = 0;
        int n2 = 0;
        boolean match = false;
        for (int i = n; i <= m; i++) {
            if (match) {

                break;
            }
            for (int j = n; j <= m; j++) {
                count++;
                if (i + j == magic) {
                    n1 += i;
                    n2 += j;
                    match = true;
                    break;
                }


            }

        }
        if (match) {
            System.out.printf("Combination N:%d (%d + %d = %d)", count, n1, n2, magic);
        } else {
            System.out.printf("%d combinations - neither equals %d", count, magic);
        }
    }
}
