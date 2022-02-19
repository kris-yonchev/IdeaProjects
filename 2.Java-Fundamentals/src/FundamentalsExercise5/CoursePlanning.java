package FundamentalsExercise5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("course start")) {
            String[] command = input.split(":");
            switch (command[0]) {
                case "Add":
                    if (!strings.contains(command[1])) {
                        strings.add(command[1]);
                    }
                    break;
                case "Insert":
                    if (!strings.contains(command[1])) {
                        if (Integer.parseInt(command[2]) >= 0 && Integer.parseInt(command[2]) <= strings.size()) {
                            strings.add(Integer.parseInt(command[2]), command[1]);
                        }
                    }
                    break;
                case "Remove":
                    if (strings.contains(command[1])) {
                        if (hasExercise(strings.indexOf(command[1]), strings)) {
                            strings.remove(strings.indexOf(command[1]) + 1);
                        }
                        strings.remove(command[1]);
                    }
                    break;
                case "Swap":
                    String stringOne = command[1] + "-Exercise";
                    String stringTwo = command[2] + "-Exercise";
                    if (strings.contains(command[1]) && strings.contains(command[2])) {
                        String nameOne = command[1];
                        int indexOne = strings.indexOf(command[1]);
                        String nameTwo = command[2];
                        int indexTwo = strings.indexOf(command[2]);
                        strings.set(indexOne, nameTwo);
                        strings.set(indexTwo, nameOne);
                        if (strings.contains(stringOne)) {
                            strings.remove(strings.indexOf(stringOne));
                            strings.add(strings.indexOf(command[1]) + 1, stringOne);
                        }
                        if (strings.contains(stringTwo)) {
                            strings.remove(strings.indexOf(stringTwo));
                            strings.add(strings.indexOf(command[2]) + 1, stringTwo);
                        }
                    }
                    break;
                case "Exercise":
                    if (!strings.contains(command[1])) {
                        strings.add(command[1]);
                        strings.add(command[1] + "-Exercise");
                    } else if (strings.contains(command[1])) {
                        if (hasExercise(strings.indexOf(command[1]), strings)) {
                            break;
                        } else {
                            strings.add(strings.indexOf(command[1])+1, command[1] + "-Exercise");
                        }
                    }
                    break;

            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(i + 1 + "." + strings.get(i));

        }
    }

    private static Boolean hasExercise(Integer s, List<String> strings) {
        String lessonName = strings.get(s);
        int index = s + 1;
        if (index < strings.size()) {
            return strings.get(s + 1).equals(lessonName + "-Exercise");
        }
        return false;

    }
}
