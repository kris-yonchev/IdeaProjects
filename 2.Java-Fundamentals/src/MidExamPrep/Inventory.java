package MidExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inventory = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Craft!")) {
            String[] command = input.split(" - |:");
            switch (command[0]) {
                case "Collect":
                    if (!inventory.contains(command[1])) {
                        inventory.add(command[1]);
                    }
                    break;
                case "Drop":
                    if (inventory.contains(command[1])) {
                        inventory.remove(command[1]);
                    }
                    break;
                case "Combine Items":
                    if (inventory.contains(command[1])) {
                        int itemIndex = inventory.indexOf(command[1]);
                        inventory.add(itemIndex + 1, command[2]);
                    }
                    break;
                case "Renew":
                    if (inventory.contains(command[1])) {
                        inventory.remove(command[1]);
                        inventory.add(command[1]);
                    }
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", inventory));
    }
}
