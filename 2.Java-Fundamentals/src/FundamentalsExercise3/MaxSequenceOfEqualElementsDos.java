package FundamentalsExercise3;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElementsDos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int maxLength = 0;
        int length = 1;
        int startIndex = 0;
        int bestIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                length++;
            } else {
                length = 1;
                startIndex = i;
            }
            if (length > maxLength) {
                maxLength = length;
                bestIndex = startIndex;

            }

        }
        for (int i = bestIndex; i < bestIndex + maxLength; i++) {

            System.out.print(array[i] + " ");
        }
    }
}
