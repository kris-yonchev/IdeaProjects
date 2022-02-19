package Exercises2;

import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double income = Double.parseDouble(scanner.nextLine());
        double average = Double.parseDouble(scanner.nextLine());
        double minsalary = Double.parseDouble(scanner.nextLine());
        double socialscholarship = minsalary * 0.35;
        double excellentscholarship = average * 25;
        if (income<minsalary && average>=5.50 && excellentscholarship>=socialscholarship){
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(excellentscholarship));
        } else if (income<minsalary&& average>=5.50&& excellentscholarship<=socialscholarship){
            System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socialscholarship));
        } else if (income>minsalary&&average>=5.50&&excellentscholarship<socialscholarship){
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(excellentscholarship));
        } else if (income<minsalary&& average>=4.50){
            System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socialscholarship));
        } else if (income>minsalary&&average>=5.50){
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(excellentscholarship));
        }
        else {
            System.out.println("You cannot get a scholarship!");
        }

    }
}
