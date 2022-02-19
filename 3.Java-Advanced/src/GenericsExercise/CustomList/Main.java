package GenericsExercise.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        CustomList<String> customList = new CustomList<>();
        while (!input.equals("END")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Add":
                    String toAdd = command[1];
                    customList.add(toAdd);
                    break;
                case "Remove":
                    int index = Integer.parseInt(command[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    String string = command[1];
                    System.out.println(customList.contains(string));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(command[1]);
                    int index2 = Integer.parseInt(command[2]);
                    customList.swap(index1, index2);
                    break;
                case "Greater":
                    String greater = command[1];
                    System.out.println(customList.countGreaterThan(greater));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    System.out.print(customList);
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
