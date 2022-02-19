package FundamentalsExercise4;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(getVowelCount(input));
    }

    private static int getVowelCount(String input) {
        int vowelCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (isVowel(symbol)) {
                vowelCount++;
            }
        }
        return vowelCount;

    }

    public static boolean isVowel(char c) {
        String vowels = "aeiouAEIOU";
        return vowels.contains(c + "");
    }
}
