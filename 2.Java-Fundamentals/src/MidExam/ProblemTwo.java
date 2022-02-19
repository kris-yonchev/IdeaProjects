package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Finish")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Add":
                    numbers.add(Integer.parseInt(command[1]));
                    break;
                case "Remove":
                    numbers.remove((Integer) (Integer.parseInt(command[1])));
                    break;
                case "Replace":
                    int indexOf = numbers.indexOf(Integer.parseInt(command[1]));
                    numbers.set(indexOf, Integer.parseInt(command[2]));

                    break;
                case "Collapse":
                    int currentNumber = Integer.parseInt(command[1]);
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) < currentNumber) {
                            numbers.remove(numbers.get(i));
                            i -= 1;
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
