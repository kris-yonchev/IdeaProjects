package FundamentalsExercise8;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String one = input[0];
        String two = input[1];
        getSum(one, two);
        System.out.println(getSum(one, two));

    }

    private static int getSum(String one, String two) {
        int sum = 0;
        int smallerString = Math.min(one.length(), two.length());

        for (int i = 0; i < smallerString; i++) {

            sum += one.charAt(i) * two.charAt(i);

        }

        if (one.length() > two.length()) {
            for (int i = two.length(); i < one.length(); i++) {
                sum += one.charAt(i);
            }
        } else if (two.length() > one.length()) {
            for (int i = one.length(); i < two.length(); i++) {
                sum += two.charAt(i);
            }
        }
        return sum;
    }
}
