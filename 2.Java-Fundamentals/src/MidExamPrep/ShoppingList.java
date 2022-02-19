package MidExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> groceries = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Go Shopping!")) {
            String[] commands = input.split(" ");
            switch (commands[0]) {
                case "Urgent":
                    if (!groceries.contains(commands[1])) {
                        groceries.add(0, commands[1]);
                    }
                    break;
                case "Unnecessary":
                    if (groceries.contains(commands[1])) {
                        groceries.remove(commands[1]);
                    }
                    break;
                case "Correct":
                    if (groceries.contains(commands[1])) {
                        groceries.set(groceries.indexOf(commands[1]), commands[2]);
                    }
                    break;
                case "Rearrange":
                    if (groceries.contains(commands[1])) {
                        groceries.remove(commands[1]);
                        groceries.add(commands[1]);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", groceries));
    }
}
