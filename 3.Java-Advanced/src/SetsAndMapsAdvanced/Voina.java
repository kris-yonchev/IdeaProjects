package SetsAndMapsAdvanced;

import java.util.*;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = getPlayerNumbers(scanner);
        LinkedHashSet<Integer> secondPlayer = getPlayerNumbers(scanner);

        for (int i = 0; i < 50; i++) {

            int firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstNumber);
            int secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);
            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }
        }


        if (firstPlayer.size() == secondPlayer.size()) {
            System.out.println("Draw!");
        } else if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        }


    }

    private static LinkedHashSet<Integer> getPlayerNumbers(Scanner scanner) {
        int[] cards = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int a : cards) {
            set.add(a);
        }
        return set;
    }
}
