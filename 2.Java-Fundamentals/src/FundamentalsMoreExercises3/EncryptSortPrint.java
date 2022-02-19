package FundamentalsMoreExercises3;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];


        for (int i = 0; i < numbers.length; i++) {
            String names = scanner.nextLine();
            int length = names.length();
            int sum = 0;


            for (int j = 0; j < names.length(); j++) {
                char currentChar = names.charAt(j);

                if (isVowel(currentChar)) {
                    sum += currentChar * length;
                } else {
                    sum += currentChar / length;
                }
            }
            numbers[i] = sum;
        }
        Arrays.sort(numbers);
        for (int element : numbers) {
            System.out.println(element);
        }
    }

    public static boolean isVowel(char c) {
        String vowels = "aeiouAEIOU";
        return vowels.contains(c + "");
    }
}
