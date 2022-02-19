package FundamentalsExercise3;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int DnaLength = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int lineCount = 0;
        int bestStartIndex = 0;
        int[] bestLine = new int[DnaLength];
        int bestLineNumber = 0;
        int bestOnes = 0;
        int bestSum = 0;
        int sum = 0;

        while (!input.equals("Clone them!")) {
            int[] currentLine = Arrays.stream((input).split("!+")).mapToInt(e -> Integer.parseInt(e)).toArray();
            lineCount++;
            int longestOnesInARow = 0;
            int startIndex = Integer.MAX_VALUE;
            for (int i = 0; i < currentLine.length; i++) {
                int onesInARow = 0;
                for (int j = i; j < currentLine.length; j++) {
                    if (currentLine[i] == currentLine[j] && currentLine[i] == 1) {
                        onesInARow++;
                        if (onesInARow > longestOnesInARow) {
                            longestOnesInARow = onesInARow;
                            startIndex = i;
                        }
                    } else {
                        break;
                    }
                }

            }
            if (longestOnesInARow > bestOnes) {
                bestOnes = longestOnesInARow;
                bestLine = currentLine;
                bestLineNumber = lineCount;
                bestStartIndex = startIndex;
            } else if (longestOnesInARow == bestOnes) {
                if (startIndex < bestStartIndex) {
                    bestLine = currentLine;
                    bestLineNumber = lineCount;
                    bestStartIndex = startIndex;
                } else if (startIndex == bestStartIndex) {

                    for (int i = 0; i < bestLine.length; i++) {
                        bestSum += bestLine[i];
                    }
                    for (int i = 0; i < currentLine.length; i++) {
                        sum += currentLine[i];
                    }
                    if (sum > bestSum) {
                        bestLine = currentLine;
                        bestLineNumber = lineCount;
                        bestSum = sum;
                    }
                }

            }
            input = scanner.nextLine();
        }
        bestSum = 0;
        for (int i = 0; i < bestLine.length; i++) {
            bestSum += bestLine[i];
        }
        if (bestSum == 0) {
            bestLineNumber = 1;
        }
        System.out.printf("Best DNA sample %d with sum: %d.\n", bestLineNumber, bestSum);
        for (int i = 0; i < bestLine.length; i++) {
            System.out.print(bestLine[i] + " ");
        }
    }
}
