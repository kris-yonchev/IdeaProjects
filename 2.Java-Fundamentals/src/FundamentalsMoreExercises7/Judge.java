package FundamentalsMoreExercises7;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Integer>> courses = new LinkedHashMap<>();
        Map<String, Integer> totalScore = new LinkedHashMap<>();

        while (!input.equals("no more time")) {
            String[] info = input.split(" -> ");
            String courseName = info[1];
            String userName = info[0];
            int score = Integer.parseInt(info[2]);

            LinkedHashMap<String, Integer> userAndScore = new LinkedHashMap<>();
            userAndScore.put(userName, score);

            courses.putIfAbsent(courseName, userAndScore);
            courses.get(courseName).putIfAbsent(userName, score);
            courses.get(courseName).put(userName, Math.max(score, courses.get(courseName).get(userName)));


            input = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : courses.entrySet()) {
            for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                totalScore.putIfAbsent(entry2.getKey(), 0);
                totalScore.put(entry2.getKey(), totalScore.get(entry2.getKey()) + entry2.getValue());
            }
        }
        courses.forEach((key, value) ->

        {
            AtomicInteger count = new AtomicInteger(1);
            System.out.printf("%s: %d participants\n", key, value.size());
            value.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                    .forEach(a -> System.out.printf("%d. %s <::> %d\n", count.getAndIncrement(), a.getKey(), a.getValue()));
        });
        AtomicInteger count = new AtomicInteger(1);
        System.out.println("Individual standings:");
        totalScore.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                        .forEach(b -> System.out.printf("%d. %s -> %d\n", count.getAndIncrement(), b.getKey(), b.getValue()));


    }
}
