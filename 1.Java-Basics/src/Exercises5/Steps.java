package Exercises5;

import java.util.Scanner;

public class Steps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int steps = 0;
        int goal = 10000;
        while (steps < goal) {
            String stuff = scanner.nextLine();
            if (stuff.equals("Going home")) {
                steps += Integer.parseInt(scanner.nextLine());
                break;
            }
            steps += Integer.parseInt(stuff);
        }
        int diff = Math.abs(goal - steps);
        if (steps >= goal) {
            System.out.printf("Goal reached! Good job!\n" +
                    "%d steps over the goal!\n", diff);
        } else {
            System.out.printf("%d more steps to reach goal.", diff);
        }
    }
}
