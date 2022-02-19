package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();
            //"us", "uk" or “com”
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                map.put(name, email);
            }

            input = scanner.nextLine();
        }
        map.forEach((key, value) -> System.out.printf("%s -> %s\n", key, value));
    }
}
