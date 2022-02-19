package Lab5;

import java.util.Scanner;

public class GraduationWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int failcount = 0;
        int counter = 1;
        double sum = 0;
        while (counter <= 12 && failcount <= 1) {
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade < 4.0) {
                failcount++;
            }
            if (grade >= 4.0) {
                counter++;
                sum += grade;
            }
        }
        double average = sum / 12;
        if (failcount <= 1) {
            System.out.printf("%s graduated. Average grade: %.2f", name, average);
        } else {
            System.out.printf("%s has been excluded at %d grade", name, counter);
        }
    }
}
