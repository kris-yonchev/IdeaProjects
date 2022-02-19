package Exercise6;

import java.util.Scanner;

public class LetterCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char c1 = scanner.next().charAt(0);
        int c2 = scanner.next().charAt(0);
        int c3 = scanner.next().charAt(0);
        int counter = 0;
        for (int i = c1; i <= c2; i++) {
            for (int j = c1; j <= c2; j++) {
                for (int k = c1; k <= c2; k++) {
                    if (i == c3 || j == c3 || k == c3) {
                        continue;
                    } else {
                        counter++;
                        System.out.printf("%c%c%c ", i, j, k);
                    }

                }

            }


        }
        System.out.print(counter);

    }
}
