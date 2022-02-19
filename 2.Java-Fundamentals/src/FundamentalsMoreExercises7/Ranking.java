package FundamentalsMoreExercises7;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> contests = new LinkedHashMap<>();
        Map<String, LinkedHashMap<String, Integer>> submissions = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("end of contests")) {
            String[] nameAndPass = input.split(":");
            String name = nameAndPass[0];
            String pass = nameAndPass[1];

            if (!contests.containsKey(name)) {
                contests.put(name, pass);
            }

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("end of submissions")) {
            String[] submission = input.split("=>");
            String contestName = submission[0];
            String pass = submission[1];
            String userName = submission[2];
            int userScore = Integer.parseInt(submission[3]);

            if (contests.containsKey(contestName)) {
                if (contests.get(contestName).equals(pass)) {
                    LinkedHashMap<String, Integer> course = new LinkedHashMap<>();
                    course.put(contestName, userScore);
                    if (!submissions.containsKey(userName)) {
                        submissions.put(userName, course);
                    } else {
                        if (!submissions.get(userName).containsKey(contestName)) {
                            submissions.get(userName).put(contestName, userScore);
                        } else {
                            submissions.get(userName).put(contestName, Math.max(userScore, submissions.get(userName).get(contestName)));
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }

        int totalSum = 0;
        String userKey = "";
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : submissions.entrySet()) {
            int sum = user.getValue().values().stream().mapToInt(i -> i).sum();
            if (sum > totalSum) {
                totalSum = sum;
                userKey = user.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.\n", userKey, totalSum);
        System.out.println("Ranking: ");
        submissions.forEach((key, value) -> {
            System.out.printf("%s\n", key);
            value.entrySet().stream().sorted((n1, n2) -> Integer.compare(n2.getValue(), n1.getValue()))
                    .forEach(i -> System.out.printf("#  %s -> %d\n", i.getKey(), i.getValue()));
        });


    }
}
