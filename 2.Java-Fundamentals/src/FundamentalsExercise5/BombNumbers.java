package FundamentalsExercise5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String[] bomb = scanner.nextLine().split(" ");
        int bombNumber = Integer.parseInt(bomb[0]);
        int bombPower = Integer.parseInt(bomb[1]);
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bombNumber) {
                int bombIndex = numbers.indexOf(bombNumber);
                for (int j = 0; j < bombPower; j++) {
                    if (bombIndex <= 0) {
                        break;
                    }
                    numbers.remove(bombIndex - 1);
                    bombIndex = bombIndex - 1;
                }
                for (int j = 0; j < bombPower; j++) {
                    if (bombIndex >= numbers.size() - 1) {
                        break;
                    }
                    numbers.remove(bombIndex + 1);
                }
                numbers.remove(bombIndex);
            }

        }
        numbers.removeIf(e -> e == bombNumber);
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        System.out.println(sum);
    }
}
