package FundamentalsExercise3;

import java.util.Arrays;
import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrayOne = scanner.nextLine().split(" ");
        String[] arrayTwo = scanner.nextLine().split(" ");
        for (int i = 0; i < arrayTwo.length; i++) {
            String symbolOne = arrayTwo[i];
            for (int j = 0; j < arrayOne.length; j++) {
                String symbolTwo = arrayOne[j];
                if (symbolTwo.equals(symbolOne)) {
                    System.out.print(symbolTwo + " ");
                }

            }

        }
    }
}
