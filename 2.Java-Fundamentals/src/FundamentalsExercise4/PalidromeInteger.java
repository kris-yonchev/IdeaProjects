package FundamentalsExercise4;

import java.util.Scanner;

public class PalidromeInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String number = input;
            getPalindrome(number);


            input = scanner.nextLine();
        }
    }

    private static void getPalindrome(String number) {
        String palindrome = "";
        for (int i = number.length() - 1; i >= 0; i--) {
            palindrome += number.charAt(i);
        }
        if (number.equals(palindrome)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
