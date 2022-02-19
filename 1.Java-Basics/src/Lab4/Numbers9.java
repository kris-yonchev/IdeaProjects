package Lab4;

import java.util.Scanner;

public class Numbers9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int leftsum = 0;
        int rightsum = 0;
        for (int i = 1; i <= n ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            leftsum += number;
        } for (int i = 1; i <=n ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            rightsum += number;
        } if (leftsum==rightsum) {
            System.out.printf("Yes, sum = %d", leftsum);
        } else {
            int missing = Math.abs(leftsum - rightsum);
            System.out.printf("No, diff = %d", missing);
        }
    }
}
