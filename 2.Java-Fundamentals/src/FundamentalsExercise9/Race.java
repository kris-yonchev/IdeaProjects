package FundamentalsExercise9;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.asList(scanner.nextLine().split(", "));
        Map<String, Integer> participants = new LinkedHashMap<>();
        String nameRegex = "[A-Za-z]+";
        String digitRegex = "[0-9]";
        String input = scanner.nextLine();
        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern digitPattern = Pattern.compile(digitRegex);

        while (!input.equals("end of race")) {

            Matcher nameMatcher = namePattern.matcher(input);
            Matcher digitMatcher = digitPattern.matcher(input);
            String name = "";
            int score = 0;
            while (digitMatcher.find()) {
                score += Integer.parseInt(digitMatcher.group());
            }

            while (nameMatcher.find()) {
                name += nameMatcher.group();
                if (names.contains(name)) {
                    participants.putIfAbsent(name, 0);
                    participants.put(name, participants.get(name) + score);
                    break;
                }
            }

            input = scanner.nextLine();
        }
        List<String> winners = participants
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.printf("1st place: %s\n2nd place: %s\n3rd place: %s\n", winners.get(0), winners.get(1), winners.get(2));
    }
}
