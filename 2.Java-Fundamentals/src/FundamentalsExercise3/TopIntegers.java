package FundamentalsExercise3;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];
            boolean isTop = true;
            for (int j = i + 1; j < numbers.length; j++) {
                if (currentNumber <= numbers[j]) {
                    isTop = false;
                    break;
                }
            }
            if (isTop) {
                System.out.print(currentNumber + " ");
            }
        }
    }
}
