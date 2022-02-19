package FundamentalsExercise8;

import java.util.Scanner;

public class LetterChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");
        double total = 0.0;
        for (String word : words) {

            double currentSum = getSum(word);
            total += currentSum;

        }
        System.out.printf("%.2f", total);

    }

    private static Double getSum(String word) {
        double sum = 0.0;
        char firstLetter = word.charAt(0);
        char secondLetter = (word.charAt(word.length() - 1));
        double number = Double.parseDouble(word.substring(1, word.length() - 1));

        if (Character.isUpperCase(firstLetter)) {
            number /= (double) firstLetter - 64;
        } else {
            number *= (double) firstLetter - 96;
        }

        if (Character.isUpperCase(secondLetter)) {
            number -= (int) secondLetter - 64;
        } else {
            number += (int) secondLetter - 96;
        }

        sum += number;

        return sum;
    }
}
