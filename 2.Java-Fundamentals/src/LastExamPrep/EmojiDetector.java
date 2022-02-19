package LastExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        long coolNumber = 1;
        String coolRegex = "\\d";
        String emojiRegex = "(?<name>([*]{2})[A-Z][a-z]{2,}([*]{2})|([:]{2})[A-Z][a-z]{2,}([:]{2}))";
        Pattern digitPattern = Pattern.compile(coolRegex);
        Pattern emojiPattern = Pattern.compile(emojiRegex);
        coolNumber = getCoolThreshold(digitPattern, input, coolNumber);
        List<String> validEmojis = new ArrayList<>();
        int emojiCount = validateEmojis(input, emojiPattern, validEmojis, coolNumber);

        System.out.printf("Cool threshold: %d\n", coolNumber);
        System.out.printf("%d emojis found in the text. The cool ones are:\n", emojiCount);
        for (String emoji : validEmojis) {
            System.out.printf("%s\n", emoji);
        }
    }

    private static int validateEmojis(String input, Pattern emojiPattern, List<String> validEmojis, long coolNumber) {
        Matcher matcher = emojiPattern.matcher(input);
        int emojiCount = 0;
        while (matcher.find()) {
            int emojiSum = 0;
            String emoji = matcher.group("name");
            emojiCount++;
            for (int i = 2; i < emoji.length()-2; i++) {
                char symbol = emoji.charAt(i);
                emojiSum += symbol;
            }
            if (emojiSum > coolNumber) {
                validEmojis.add(matcher.group());
            }
        }
        return emojiCount;
    }

    private static long getCoolThreshold(Pattern digitPattern, String input, long coolNumber) {
        Matcher matcher = digitPattern.matcher(input);
        while (matcher.find()) {
            coolNumber *= Integer.parseInt(matcher.group());
        }
        return coolNumber;

    }
}
