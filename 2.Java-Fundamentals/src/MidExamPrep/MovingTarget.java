package MidExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commands = input.split(" ");
            switch (commands[0]) {
                case "Shoot":
                    if (isOutOfBounds(commands[1], targets)) {
                        break;
                    }
                    int currentIndex = targets.get(Integer.parseInt(commands[1]));
                    targets.set(Integer.parseInt(commands[1]), currentIndex - Integer.parseInt(commands[2]));
                    if (targets.get(Integer.parseInt(commands[1])) <= 0) {
                        targets.remove(Integer.parseInt(commands[1]));
                    }
                    break;
                case "Add":
                    if (isOutOfBounds(commands[1], targets)) {
                        System.out.println("Invalid placement!");
                    } else {
                        targets.add(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                    }
                    break;
                case "Strike":
                    if (isOutOfBounds(commands[1], targets)) {
                        System.out.println("Strike missed!");
                    }
                    if (Integer.parseInt(commands[1]) + Integer.parseInt(commands[2]) > targets.size() - 1 || Integer.parseInt(commands[1]) - Integer.parseInt(commands[2]) < 0) {
                        System.out.println("Strike missed!");
                    } else {
                        for (int i = 0; i <= Integer.parseInt(commands[2]) * 2; i++) {
                            targets.remove(Integer.parseInt(commands[1]) - Integer.parseInt(commands[2]));
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < targets.size(); i++) {
            if (i == targets.size() - 1) {
                System.out.print(targets.get(i));
            } else {
                System.out.print(targets.get(i) + "|");
            }
        }

    }

    private static boolean isOutOfBounds(String command, List<Integer> targets) {
        return Integer.parseInt(command) > targets.size() - 1 || Integer.parseInt(command) < 0;
    }

}
