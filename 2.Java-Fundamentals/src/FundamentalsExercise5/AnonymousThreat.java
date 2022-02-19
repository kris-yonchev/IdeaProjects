package FundamentalsExercise5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("3:1")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "merge":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    mergeLine(strings, startIndex, endIndex);
                    break;
                case "divide":
                    int divideIndex = Integer.parseInt(command[1]);
                    int partitions = Integer.parseInt(command[2]);

                    String currentElement = strings.get(divideIndex);
                    int substringLength = currentElement.length() / partitions;
                    int begin = 0;
                    strings.remove(divideIndex);
                    for (int i = 1; i < partitions; i++) {
                        strings.add(divideIndex, currentElement.substring(begin, begin + substringLength));
                        divideIndex++;
                        begin += substringLength;
                    }
                    strings.add(divideIndex, currentElement.substring(begin));
                    break;

            }

            input = scanner.nextLine();
        }
        for (String string : strings) {
            System.out.print(string + " ");
        }
    }

    private static void mergeLine(List<String> strings, int startIndex, int endIndex) {
        if (startIndex < 0) {
            startIndex = 0;
        }
        if (endIndex > strings.size() - 1) {
            endIndex = strings.size() - 1;
        }
        int currentIndex = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            String result = strings.get(currentIndex) + strings.get(currentIndex + 1);
            strings.set(currentIndex, result);
            strings.remove(strings.get(currentIndex + 1));
        }
    }
}
