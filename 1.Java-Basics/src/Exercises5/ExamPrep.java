package Exercises5;

import java.util.Scanner;

public class ExamPrep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int poor = Integer.parseInt(scanner.nextLine());
        String name = scanner.nextLine();
        int poorgrades = 0;
        boolean fail = false;
        double gradesum = 0.0;
        int problem = 0;
        String last = "";
        int gradecount = 0;

        while (!name.equals("Enough")) {
            int grade = Integer.parseInt(scanner.nextLine());
            problem++;
            gradecount++;
            gradesum += grade;
            last = name;
            if (grade <= 4) {
                poorgrades++;
                if (poorgrades == poor) {
                    fail = true;
                    break;
                }
            }
            name = scanner.nextLine();
        }
        double avg = gradesum / gradecount;
        if (fail) {
            System.out.printf("You need a break, %d poor grades.", poor);
        } else {
            System.out.printf("Average score: %.2f\n" +
                    "Number of problems: %d\n" +
                    "Last problem: %s\n", avg, problem, last);

        }
    }
}
