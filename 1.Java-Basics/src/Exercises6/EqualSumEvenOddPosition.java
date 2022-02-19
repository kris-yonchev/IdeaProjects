package Exercise6;

import java.util.Scanner;

public class EqualSumEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        for (int i = n1; i <= n2; i++) {
            String number = "" + i;
            int odd = 0;
            int even = 0;
            for (int j = 0; j < number.length(); j++) {
                int digit = Integer.parseInt("" + number.charAt(j));
                if (j % 2 == 0) {
                    even += digit;
                } else {
                    odd += digit;
                }

            }
            if (even == odd) {
                System.out.print(i + " ");
            }

        }
    }
}
