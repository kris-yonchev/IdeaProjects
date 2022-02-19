package ExamPrep.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public List<Student> students;
    public int capacity;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        String output;
        if (this.students.size() < capacity) {
            if (students.contains(student)) {
                output = "Student is already in the university";
            } else {
                students.add(student);
                output = "Added student " + student.getFirstName() + " " + student.getLastName();

            }
        } else {
            output = "No seats in the university";
        }
        return output;
    }

    public String dismissStudent(Student student) {
        String output;
        if (students.contains(student)) {
            students.remove(student);
            output = "Removed student " + student.getFirstName() + " " + student.getLastName();
        } else {
            output = "Student not found";
        }
        return output;
    }

    public Student getStudent(String firstName, String lastName) {
        Student student = null;
        for (Student s : students) {
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                student = s;
            }
        }
        return student;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append("==Student: First Name = ").append(s.getFirstName())
                    .append(", Last Name = ").append(s.getLastName())
                    .append(", Best Subject = ").append(s.getBestSubject())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
