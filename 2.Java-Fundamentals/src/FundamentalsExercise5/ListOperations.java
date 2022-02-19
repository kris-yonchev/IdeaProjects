package FundamentalsExercise5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commands = input.split("\\s+");
            switch (commands[0]) {
                case "Add":
                    numbers.add(commands[1]);
                    break;
                case "Insert":
                    if (Integer.parseInt(commands[2]) > numbers.size() || Integer.parseInt(commands[2]) < 0) {
                        System.out.println("Invalid index");
                        break;
                    }
                    numbers.add(Integer.parseInt(commands[2]), (commands[1]));
                    break;
                case "Remove":
                    if (Integer.parseInt(commands[1]) > numbers.size() || Integer.parseInt(commands[1]) < 0) {
                        System.out.println("Invalid index");
                        break;
                    }
                    numbers.remove(Integer.parseInt(commands[1]));
                    break;
                case "Shift":
                    if (commands[1].equals("left")) {
                        getShiftLeftIndex(numbers, commands[2]);
                    } else if (commands[1].equals("right")) {
                        getShiftRightIndex(numbers, commands[2]);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void getShiftRightIndex(List<String> numbers, String command) {
        for (int i = 0; i < Integer.parseInt(command); i++) {
            numbers.add(0, numbers.get(numbers.size() - 1));
            numbers.remove(numbers.size() - 1);
        }
    }

    private static void getShiftLeftIndex(List<String> numbers, String command) {
        for (int i = 0; i < Integer.parseInt(command); i++) {
            numbers.add(numbers.size(), numbers.get(0));
            numbers.remove(0);
        }
    }
}
