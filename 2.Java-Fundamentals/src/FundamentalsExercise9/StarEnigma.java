package FundamentalsExercise9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String starRegex = "[STARstar]";
        List<StringBuilder> messages = new ArrayList<>();
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            messages.add(getDecryptedMessage(input, starRegex));

        }
        for (StringBuilder message : messages) {
            String planetRegex = "@(?<name>[A-z]+)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*?!(?<attackType>[AD])![^@\\-!:>]*?->(?<soldiers>\\d+)";
            Pattern pattern = Pattern.compile(planetRegex);
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) {
                String planet = matcher.group("name");
                String ad = matcher.group("attackType");

                if (ad.equals("A")) {
                    attacked.add(planet);
                } else {
                    destroyed.add(planet);
                }

            }

        }
        System.out.printf("Attacked planets: %d\n", attacked.size());
        attacked.stream().sorted().forEach(planet -> System.out.println("-> " + planet));
        System.out.printf("Destroyed planets: %d\n", destroyed.size());
        destroyed.stream().sorted().forEach(planet -> System.out.println("-> " + planet));
    }

    private static StringBuilder getDecryptedMessage(String input, String starRegex) {
        Pattern pattern = Pattern.compile(starRegex);
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        StringBuilder decryption = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char symbol = (char) (input.charAt(i)-count);
            decryption.append(symbol);

        }
        return decryption;
    }
}
