package ExamExercise;

import java.util.Scanner;

public class Actors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("ACTION")) {
            String name = input;
            if (name.length() > 15) {
                var salary = budget * 0.2;
                budget -= salary;
                if (budget < 0) {
                    break;
                }
                input = scanner.nextLine();
                continue;
            }
            double salary = Double.parseDouble(scanner.nextLine());
            budget -= salary;
            if (budget < 0) {
                break;
            }
            input = scanner.nextLine();
        }
        if (budget < 0) {
            System.out.printf("We need %.2f leva for our actors.", Math.abs(budget));
        } else {
            System.out.printf("We are left with %.2f leva.", budget);
        }
    }
}
