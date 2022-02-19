package FundamentalsMoreExercises2;

import java.util.Scanner;

public class Decryptions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int letters = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= letters; i++) {
            char symbol = scanner.nextLine().charAt(0);

            System.out.printf("%c", symbol + key);

        }
    }
}
