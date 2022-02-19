package Exercise4;

import java.util.Scanner;

public class GradesSmthSmth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        int s1 = 0;
        int s2 = 0;
        int s3 = 0;
        int s4 = 0;
        int fail = 0;
        double average = 0.0;
        for (int i = 1; i <= students; i++) {
            double grades = Double.parseDouble(scanner.nextLine());
            average += grades;
            if (grades < 3.00) {
                fail++;
            }
            if (grades <= 2.99) {
                s1++;
            } else if (grades <= 3.99 && grades>=3.00) {
                s2++;
            } else if (grades <= 4.99) {
                s3++;
            } else if (grades >= 5.00) {
                s4++;
            }
        }
        double fail1 = (1.0 * fail / students) * 100;
        double rank2 = (1.0 * s2 / students) * 100;
        double rank3 = (1.0 * s3 / students) * 100;
        double rank4 = (1.0 * s4 / students) * 100;
        double average1 = (average / students);
        System.out.printf("Top students: %.2f%%\nBetween 4.00 and 4.99: %.2f%%\nBetween 3.00 and 3.99: %.2f%%\nFail: %.2f%%\nAverage: %.2f", rank4, rank3, rank2, fail1, average1);
    }
}
