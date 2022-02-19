package MidExamPrep;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String letters = scanner.nextLine();
        int maxLength = 0;
        for (int i = 0; i < letters.length(); i++) {
            maxLength = Math.max(maxLength, getPalindrome(i, i, letters));
        }
        for (int i = 0; i < letters.length(); i++) {
            maxLength = Math.max(maxLength, getPalindrome(i, i+1, letters));
        }
        System.out.println(maxLength);
    }

    private static int getPalindrome(int leftIndex, int rightIndex, String letters) {
        while (leftIndex>=0 && rightIndex<letters.length() && letters.charAt(leftIndex)==letters.charAt(rightIndex)) {
            leftIndex--;
            rightIndex++;
        }
        return rightIndex-leftIndex-1;
    }
}
