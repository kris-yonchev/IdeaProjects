package Lab4;

import java.util.Scanner;

public class Numbers10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int oddsum = 0;
        int evensum = 0;
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0) {
                evensum = evensum + number;
            } else {
                oddsum = oddsum + number;
            }
        }
        if (evensum == oddsum) {
            System.out.printf("Yes\nSum = %d", evensum);
        } else {
            System.out.printf("No\nDiff = %d", Math.abs(evensum - oddsum));
        }

    }
}
