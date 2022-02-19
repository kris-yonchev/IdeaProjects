package ExamExercise;

import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kg = Integer.parseInt(scanner.nextLine()) * 1000;
        String end = scanner.nextLine();
        int food = 0;
        while (!end.equals("Adopted")) {
            int eaten = Integer.parseInt(end);
            food += eaten;


            end = scanner.nextLine();
        }
        if (food <= kg) {
            System.out.printf("Food is enough! Leftovers: %d grams.", Math.abs(kg - food));
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", Math.abs(kg - food));
        }
    }
}
