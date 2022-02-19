package FundamentalsExercise3;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBug {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] field = new int[n];

        String[] bugIndexes = scanner.nextLine().split(" ");
        for (int i = 0; i < bugIndexes.length; i++) {
            int bugIndex = Integer.parseInt(bugIndexes[i]);

            if (bugIndex < field.length && bugIndex >= 0) {
                field[bugIndex] = 1;
            }

        }
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] commands = input.split(" ");
            int bugIndex = Integer.parseInt(commands[0]);
            int flyLength = Integer.parseInt(commands[2]);
            String direction = commands[1];

            if (bugIndex < 0 || bugIndex >= field.length || field[bugIndex] != 1) {
                input = scanner.nextLine();
                continue;
            }

            field[bugIndex] = 0;

            if (direction.equals("right")) {
                bugIndex += flyLength;

                while (bugIndex < field.length && field[bugIndex] == 1) {
                    bugIndex += flyLength;
                }
                if (bugIndex < field.length) {
                    field[bugIndex] = 1;
                }
            } else {
                bugIndex -= flyLength;

                while (bugIndex >= 0 && field[bugIndex] == 1) {
                    bugIndex -= flyLength;
                }
                if (bugIndex >= 0) {
                    field[bugIndex] = 1;
                }
            }

            input = scanner.nextLine();
        }
        for (int i = 0; i < field.length; i++) {
            System.out.print(field[i] + " ");

        }
    }
}
