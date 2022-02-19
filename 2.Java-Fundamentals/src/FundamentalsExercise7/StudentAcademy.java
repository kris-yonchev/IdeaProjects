package FundamentalsExercise7;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> holdingCount = new LinkedHashMap<>();
        Map<String, Double> students = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            double studentGrade = Double.parseDouble(scanner.nextLine());

            if (!students.containsKey(studentName)) {
                students.put(studentName, studentGrade);
                holdingCount.put(studentName, 1);

            } else {
                holdingCount.put(studentName, holdingCount.get(studentName) + 1);
                double averageGrade = (students.get(studentName) + studentGrade) / holdingCount.get(studentName);
                students.put(studentName, averageGrade);

            }
        }
        students.entrySet()
                .stream()
                .filter(e -> e.getValue() >= 4.5)
                .sorted((n1, n2) -> Double.compare(n2.getValue(), n1.getValue()))
                .forEach(e -> System.out.printf("%s -> %.2f\n", e.getKey(), e.getValue()));
    }
}
