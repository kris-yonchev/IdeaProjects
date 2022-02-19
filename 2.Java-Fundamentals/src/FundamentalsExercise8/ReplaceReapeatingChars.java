package FundamentalsExercise8;

import java.util.Scanner;

public class ReplaceReapeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt(i - 1)) {
                sb.append(input.charAt(i));
            }
        }
        System.out.println(sb);
    }
}
