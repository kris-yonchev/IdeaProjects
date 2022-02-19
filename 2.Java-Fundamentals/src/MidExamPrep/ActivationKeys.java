package MidExamPrep;

import java.util.*;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            list.add(String.valueOf(string.charAt(i)));
        }
        String input = scanner.nextLine();
        while (!input.equals("Generate")) {
            String[] commands = input.split(">>>");
            switch (commands[0]) {
                case "Contains":
                    String substring = commands[1];

                    if (list.toString().replaceAll("[\\[\\]\\s+,]", "").contains(substring)) {
                        System.out.print(list.toString().replaceAll("[\\[\\],\\s+]", ""));
                        System.out.println(" contains " + substring);

                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String commandTwo = commands[1];
                    int beginIndex = Integer.parseInt(commands[2]);
                    int endIndex = Integer.parseInt(commands[3]);
                    if (commandTwo.equals("Upper")) {
                        for (int i = beginIndex; i < endIndex; i++) {
                            String current = list.get(i);
                            list.set(i, current.toUpperCase(Locale.ROOT));
                        }
                    } else {
                        for (int i = beginIndex; i < endIndex; i++) {
                            String current = list.get(i);
                            list.set(i, current.toLowerCase(Locale.ROOT));
                        }
                    }
                    System.out.println(list.toString().replaceAll("[\\[\\],\\s+]", ""));
                    break;
                case "Slice":
                    int indexOne = Integer.parseInt(commands[1]);
                    int indexTwo = Integer.parseInt(commands[2]);
                    for (int i = indexOne; i < indexTwo; i++) {
                        list.remove(indexOne);
                    }
                    System.out.println(list.toString().replaceAll("[\\[\\],\\s+]", ""));
                    break;

            }
            input = scanner.nextLine();
        }
        System.out.print("Your activation key is: ");
        System.out.println(list.toString().replaceAll("[\\[\\],\\s+]", ""));
    }
}
