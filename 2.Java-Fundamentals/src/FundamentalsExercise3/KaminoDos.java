package FundamentalsExercise3;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoDos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int[] dnaLength = new int[n];
        int count = 0;
        int longestSequence = 0;
        int bestCount = 0;
        int bestSum = 0;
        int bestIndex = n;
        while (!input.equals("Clone them!")) {
            int[] currentLine = Arrays.stream(input.split("!+")).mapToInt(e -> Integer.parseInt(e)).toArray();
            count++;
            int currentIndex = 0;
            int currentSum = 0;
            int currentSequence = 0;
            int bestSequence = 0;
            for (int i = 0; i < currentLine.length; i++) {
                currentSum += currentLine[i];
                if (currentLine[i] == 1) {
                    currentSequence++;
                } else {
                    currentSequence = 0;
                }
                if (currentSequence > bestSequence) {
                    bestSequence = currentSequence;
                    currentIndex = i - currentSequence + 1;
                }


            }
            if ((bestSequence > longestSequence)
                    || (bestSequence == longestSequence && bestIndex > currentIndex)
                    || (bestSequence == longestSequence && bestIndex == currentIndex && currentSum > bestSum)) {
                longestSequence = bestSequence;
                bestSum = currentSum;
                bestIndex = currentIndex;
                bestCount = count;
                dnaLength = currentLine;

            }


            input = scanner.nextLine();

        }
        System.out.printf("Best DNA sample %d with sum: %d.\n", bestCount, bestSum);
        for (int num : dnaLength) {
            System.out.print(num + " ");
        }

    }
}
