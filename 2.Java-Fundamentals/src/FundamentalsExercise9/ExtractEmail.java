package FundamentalsExercise9;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(?<user>\\s[a-z0-9][\\.\\-\\_a-z0-9]*[a-z0-9])@(?<host>[a-z][\\-\\.a-z]*[a-z]\\.[a-z]{2,})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group().trim());
        }
    }
}
