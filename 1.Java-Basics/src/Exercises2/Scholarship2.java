package Exercises2;

import java.util.Scanner;

public class Scholarship2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double incomeLeva = Double.parseDouble(scanner.nextLine());
        double averageGrade = Double.parseDouble(scanner.nextLine());
        double LowestSalary = Double.parseDouble(scanner.nextLine());
        double social = LowestSalary * 0.35;
        double grades = averageGrade * 25;

        boolean applicableForSocial = incomeLeva < LowestSalary && averageGrade > 4.5;
        boolean applicableForExcellent = averageGrade >= 5.5;
        boolean preferSocialScholarship = social > grades;

        if (applicableForSocial && applicableForExcellent) {
            if (preferSocialScholarship) {
                System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(social));
            } else {
                System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(grades));
            }
        } else if (applicableForExcellent) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(grades));
        } else if (applicableForSocial) {
            System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(social));
        } else {
            System.out.println("You cannot get a scholarship!");
        }
    }
}
