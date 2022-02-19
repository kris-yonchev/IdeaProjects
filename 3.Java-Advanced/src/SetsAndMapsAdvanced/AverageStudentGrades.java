package SetsAndMapsAdvanced;

import java.util.*;

public class AverageStudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] student = scanner.nextLine().split("\\s+");
            String name = student[0];
            double grade = Double.parseDouble(student[1]);

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);

        }

        students.forEach((key, value) -> {

            System.out.printf("%s -> ", key);
            double avg = 0;
            for (double val : value) {
                System.out.printf("%.2f ", val);
                avg += val;
            }
            System.out.printf("(avg: %.2f)", avg / value.size());
            System.out.println();

        });

    }
}
