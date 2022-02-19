package IteratorAndComparatorExercise.StackIterator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Stack stack = new Stack();

        while (!input.equals("END")) {
            String[] command = input.split("[\\s,]+");

            switch (command[0]) {
                case "Push":
                    if (command.length > 1) {
                        for (String e : Arrays.copyOfRange(command, 1, command.length) ) {
                            stack.push(e);
                        }
                    } else {
                        stack = new Stack();
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }


            input = scanner.nextLine();
        }

        stack.forEach(System.out::println);
    }
}
