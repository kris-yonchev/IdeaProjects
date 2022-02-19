package FundamentalsExercise7;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] info = input.split(" : ");
            String courseName = info[0];
            String name = info[1];
            if (!courses.containsKey(courseName)) {
                courses.put(courseName, new ArrayList<>());
            }
            courses.get(courseName).add(name);

            input = scanner.nextLine();
        }
        courses.entrySet().stream().sorted((n1, n2) -> Integer.compare(n2.getValue().size(), n1.getValue().size()))
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    List<String> students = e.getValue();
                    students.stream().sorted().forEach(s -> System.out.println("-- " + s));
                });
    }
}
