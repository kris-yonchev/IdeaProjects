package FundamentalsLecture5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] commands = input.split(" ");
            switch (commands[0]) {
                case "Contains":
                    if (numbers.contains(Integer.parseInt(commands[1]))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (commands[1].equals("even")) {
                        String evenNums = "";
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) % 2 == 0) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println(evenNums);
                    } else {
                        String oddNums = "";

                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) % 2 != 0) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println(oddNums);
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (int i = 0; i < numbers.size(); i++) {
                        sum += numbers.get(i);
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    for (int i = 0; i < numbers.size(); i++) {
                        if (commands[1].equals("<")) {
                            if (numbers.get(i) < Integer.parseInt(commands[2])) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        } else if (commands[1].equals(">")) {
                            if (numbers.get(i) > Integer.parseInt(commands[2])) {
                                System.out.print(numbers.get(i) + " ");
                            }

                        } else if (commands[1].equals(">=")) {
                            if (numbers.get(i) >= Integer.parseInt(commands[2])) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        } else if (commands[1].equals("<=")) {
                            if (numbers.get(i) <= Integer.parseInt(commands[2])) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;

            }
            input = scanner.nextLine();
        }
    }
}
