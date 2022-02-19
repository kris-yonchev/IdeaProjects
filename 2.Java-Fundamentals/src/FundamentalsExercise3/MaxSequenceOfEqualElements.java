package FundamentalsExercise3;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int index = 0;
        int maxCount = 0;
        int bestSeqIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            int counter = 0;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    counter++;
                    index = i;
                    if (counter > maxCount) {
                        maxCount = counter;
                        bestSeqIndex = index;
                    }
                } else {
                    break;
                }

            }

        }

        for (int i = 0; i < maxCount; i++) {
            System.out.print(numbers[i + bestSeqIndex] + " ");
        }

    }
}
