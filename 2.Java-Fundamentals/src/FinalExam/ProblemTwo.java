package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String regex = "(?<separator>[\\*@])(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<word1>[A-Za-z])\\]\\|\\[(?<word2>[A-Za-z])\\]\\|\\[(?<word3>[A-Za-z])\\]\\|$";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String message = scanner.nextLine();
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) {
                String tag = matcher.group("tag");
                String one = matcher.group("word1");
                String two = matcher.group("word2");
                String three = matcher.group("word3");
                int number = one.charAt(0);
                int number2 = two.charAt(0);
                int number3 = three.charAt(0);
                System.out.printf("%s: %d %d %d\n", tag, number, number2, number3);

            } else {
                System.out.println("Valid message not found!");
            }

        }
    }
}
