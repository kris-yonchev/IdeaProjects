package Exercise6;

import java.util.Scanner;

public class EvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int limit1 = Integer.parseInt(scanner.nextLine());
        int limit2 = Integer.parseInt(scanner.nextLine());
        for (int i = n1; i <= n1 + limit1; i++) {
            for (int j = n2; j <= n2 + limit2; j++) {
                boolean isPrime = true;
                boolean isPrime2 = true;
                for (int k = 2; k < n1; k++) {
                    if (i % k == 0) {
                        isPrime = false;
                        break;
                    }
                    for (int l = 2; l < n2; l++) {
                        if (j % l == 0) {
                            isPrime2 = false;
                            break;
                        }

                    }

                }
                if (isPrime && isPrime2) {
                    System.out.printf("%d%d\n", i, j);

                }


            }
        }
    }
}
