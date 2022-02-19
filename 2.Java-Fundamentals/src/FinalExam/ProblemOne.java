package FinalExam;

import java.util.Scanner;

public class ProblemOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringToManipulate = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Change":
                    String charToReplace = command[1];
                    String replacement = command[2];
                    if (stringToManipulate.contains(charToReplace)) {
                        stringToManipulate = stringToManipulate.replaceAll(charToReplace, replacement);
                    }
                    System.out.println(stringToManipulate);
                    break;
                case "Includes":
                    String stringToContain = command[1];
                    if (stringToManipulate.contains(stringToContain)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String endString = command[1];
                    int beginIndex = stringToManipulate.length() - endString.length();
                    if (stringToManipulate.substring(beginIndex).equals(endString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    StringBuilder newPass = new StringBuilder();
                    for (int i = 0; i < stringToManipulate.length(); i++) {
                        char symbol = stringToManipulate.charAt(i);
                        newPass.append(Character.toUpperCase(symbol));
                    }
                    stringToManipulate = newPass.toString();
                    System.out.println(stringToManipulate);
                    break;
                case "FindIndex":
                    String charToFind = command[1];
                    int firstIndex = stringToManipulate.indexOf(charToFind);
                    System.out.println(firstIndex);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);
                    int endIndex = startIndex + length;
                    stringToManipulate = stringToManipulate.substring(startIndex, endIndex);
                    System.out.println(stringToManipulate);
                    break;
            }
            input = scanner.nextLine();
        }

    }
}
