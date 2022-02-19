package workingWithAbstraction.studentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> students;

    public StudentSystem() {
        this.students = new HashMap<>();
    }

    public Map<String, Student> getStudents() {
        return this.students;
    }

    public void ParseCommand(String[] command) {

        switch (command[0]) {
            case "Create":
                String name = command[1];
                int age = Integer.parseInt(command[2]);
                double grade = Double.parseDouble(command[3]);
                students.putIfAbsent(name, new Student(name, age, grade));
                break;
            case "Show":
                String nameToShow = command[1];
                if (students.containsKey(nameToShow)) {
                    System.out.println(getStudentInfo(this.students.get(nameToShow))
                            + getStudentComment(this.students.get(nameToShow).getGrade()));
                }
                break;
        }

    }

    private String getStudentComment(Double grade) {
        if (grade >= 5.00) {
            return "Excellent student";
        } else if (grade >= 3.50) {
            return "Average student";
        }
        return "Very nice interfaceAndAbstractionExercise.person";
    }

    public String getStudentInfo(Student student) {
        return String.format("%s is %s years old. ", student.getName(), student.getAge());
    }
}
