package Exercise6;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int counter = 1;
        boolean bigger = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (counter > n) {
                    bigger = true;
                    break;
                }
                System.out.print(counter + " ");
                counter++;
            }
            if (bigger) {
                break;
            }
            System.out.println();
        }
    }
}
