package Exercise6;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int magic = Integer.parseInt(scanner.nextLine());
        int combo = 0;
        int number1 = 0;
        int number2 = 0;
        boolean over = false;
        for (int i = n1; i <= n2; i++) {
            if (over) {
                break;
            }
            for (int j = n1; j <= n2; j++) {
                combo++;
                if (i + j == magic) {
                    number1 += i;
                    number2 += j;
                    over = true;
                    break;
                }
            }
        }
        if (over) {
            System.out.printf("Combination N:%d (%d + %d = %d)", combo, number1, number2, magic);
        } else {

            System.out.printf("%d combinations - neither equals %d", combo, magic);
        }
    }
}
