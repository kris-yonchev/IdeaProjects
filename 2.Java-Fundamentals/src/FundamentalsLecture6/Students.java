package FundamentalsLecture6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String city = tokens[3];
            if (!studentAlreadyExists(firstName, lastName, age, city, students)) {

                Student student = new Student(firstName, lastName, age, city);
                students.add(student);
            }
            input = scanner.nextLine();
        }
        String city = scanner.nextLine();

        List<Student> filteredCity = students.stream().filter(e -> e.getCity().equals(city)).collect(Collectors.toList());
        for (Student student : filteredCity) {
            System.out.printf("%s %s is %d years old\n", student.getFirstName(), student.getLastName(), student.getAge());
        }

    }

    private static boolean studentAlreadyExists(String firstName, String lastName, int age, String city, List<Student> students) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                student.setAge(age);
                student.setCity(city);
                return true;
            }
        }
            return false;
    }

    public static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private String city;

        public Student(String firstName, String lastName, int age, String city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
