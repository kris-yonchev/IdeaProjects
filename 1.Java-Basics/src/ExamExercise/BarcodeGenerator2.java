package ExamExercise;

import java.util.Scanner;

public class BarcodeGenerator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        int n14 = number1 % 10;
        int n13 = (number1 / 10) % 10;
        int n12 = (number1 / 100) % 10;
        int n11 = (number1 / 1000) % 10;

        int n24 = number2 % 10;
        int n23 = (number2 / 10) % 10;
        int n22 = (number2 / 100) % 10;
        int n21 = (number2 / 1000) % 10;
        for (int i = n11; i <= n21; i++) {
            for (int j = n12; j <= n22; j++) {
                for (int k = n13; k <= n23; k++) {
                    for (int l = n14; l <= n24; l++) {
                        if (i % 2 != 0 && k % 2 != 0 && j % 2 != 0 && l % 2 != 0)
                            System.out.printf("%d%d%d%d ", i, j, k, l);

                    }
                }
            }
        }

    }
}
