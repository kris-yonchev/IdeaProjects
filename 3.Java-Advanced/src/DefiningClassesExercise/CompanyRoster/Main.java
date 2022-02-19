package DefiningClassesExercise.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            Employee employee = null;
            String empName = data[0];
            double empSalary = Double.parseDouble(data[1]);
            String empPosition = data[2];
            String empDepartment = data[3];
            if (data.length == 5) {
                try {
                    int empAge = Integer.parseInt(data[4]);
                    employee = new Employee(empName, empSalary, empPosition, empDepartment, empAge);
                } catch (NumberFormatException e) {
                    String empEmail = data[4];
                    employee = new Employee(empName, empSalary, empPosition, empDepartment, empEmail);
                }

            } else if (data.length == 6) {
                String empEmail = data[4];
                int empAge = Integer.parseInt(data[5]);
                employee = new Employee(empName, empSalary, empPosition, empDepartment, empEmail, empAge);
            } else {
                employee = new Employee(empName, empSalary, empPosition, empDepartment);
            }
            departments.putIfAbsent(empDepartment, new Department(empDepartment));
            departments.get(empDepartment).getEmployees().add(employee);
        }

        Department maxAvg = departments.entrySet().stream().max(Comparator.comparing(e -> e.getValue().getAverageSalary()))
                .get()
                .getValue();
        System.out.printf("Highest Average Salary: %s\n", maxAvg.getName());
        maxAvg.getEmployees().stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);

    }
}
