package FundamentalsExercise3;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int magicNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numbers.length; i++) {
            int indexOne = 0;
            int indexTwo = 0;
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == magicNumber) {
                    indexOne = numbers[i];
                    indexTwo = numbers[j];
                System.out.printf("%d %d\n", indexOne, indexTwo);

                }
            }

        }

    }
}
