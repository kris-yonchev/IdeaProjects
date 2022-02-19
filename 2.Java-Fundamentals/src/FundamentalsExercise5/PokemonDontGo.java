package FundamentalsExercise5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        while (!numbers.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            int indexToRemove = 0;
            if (index < 0) {
                indexToRemove = numbers.remove(0);
                sum += indexToRemove;
                numbers.add(0, numbers.get(numbers.size() - 1));
            } else if (index > numbers.size() - 1) {
                indexToRemove = numbers.remove(numbers.size() - 1);
                sum += indexToRemove;
                numbers.add(numbers.get(0));
            } else {
                indexToRemove = numbers.remove(index);
                sum += indexToRemove;
            }
            for (int i = 0; i < numbers.size(); i++) {
                int currentNumber = numbers.get(i);
                if (currentNumber <= indexToRemove) {
                    currentNumber += indexToRemove;
                } else {
                    currentNumber -= indexToRemove;
                }
                numbers.set(i, currentNumber);
            }

        }
        System.out.println(sum);
    }
}
