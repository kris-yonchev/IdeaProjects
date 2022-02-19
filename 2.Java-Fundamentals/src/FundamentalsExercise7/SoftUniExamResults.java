package FundamentalsExercise7;

import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> results = new HashMap<>();
        Map<String, Integer> submissions = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("exam finished")) {
            String[] command = input.split("-");

            String userName = command[0];
            String userLanguage = command[1];
            if (command[1].equals("banned")) {

                results.remove(userName);

            } else {

                int score = Integer.parseInt(command[2]);

                if (!results.containsKey(userName)) {
                    results.put(userName, score);
                } else if (results.get(userName) < score) {

                    results.put(userName, score);
                }

                if (!submissions.containsKey(userLanguage)) {
                    submissions.put(userLanguage, 0);
                }
                submissions.put(userLanguage, submissions.get(userLanguage) + 1);
            }


            input = scanner.nextLine();
        }
        System.out.println("Results:");
        results
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.printf("%s | %d\n", e.getKey(), e.getValue()));

        System.out.println("Submissions:");
        submissions
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(sub -> System.out.printf("%s - %d\n", sub.getKey(), sub.getValue()));
    }
}
