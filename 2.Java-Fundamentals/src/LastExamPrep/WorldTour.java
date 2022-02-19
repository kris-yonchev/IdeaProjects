package LastExamPrep;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String[] command = input.split(":");
            switch (command[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(command[1]);
                    String cityName = command[2];
                    if (indexIsValid(index, sb.toString())) {
                        sb.insert(index, cityName);
                    }
                    break;
                case "Remove Stop":
                    int beginIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    if (indexIsValid(beginIndex, sb.toString()) && indexIsValid(endIndex, sb.toString())) {
                        sb.delete(beginIndex, endIndex + 1);
                    }
                    break;
                case "Switch":
                    String oldString = command[1];
                    String newString = command[2];
                    String destinationToString = sb.toString();
                    destinationToString = destinationToString.replaceAll(oldString, newString);
                    sb = new StringBuilder(destinationToString);

                    break;
            }
            System.out.println(sb);
            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + sb);
    }

    private static boolean indexIsValid(int index, String text) {
        return index >= 0 && index < text.length();
    }
}
