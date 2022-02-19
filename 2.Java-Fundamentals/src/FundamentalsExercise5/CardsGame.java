package FundamentalsExercise5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> playerOneHand = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> playerTwoHand = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        String winner;

        while (!isEmpty(playerOneHand, playerTwoHand)) {

            if (playerOneHand.get(0) > playerTwoHand.get(0)) {
                playerOneHand.add(playerOneHand.get(0));
                playerOneHand.add(playerTwoHand.get(0));
                playerOneHand.remove(0);
                playerTwoHand.remove(0);
            } else if (playerTwoHand.get(0) > playerOneHand.get(0)) {
                playerTwoHand.add(playerTwoHand.get(0));
                playerTwoHand.add(playerOneHand.get(0));
                playerTwoHand.remove(0);
                playerOneHand.remove(0);
            } else if (playerOneHand.get(0).equals(playerTwoHand.get(0))) {
                playerTwoHand.remove(0);
                playerOneHand.remove(0);
            }
        }
        if (playerOneHand.isEmpty()) {
            winner = "Second player";
            for (Integer integer : playerTwoHand) {
                sum += integer;
            }
        } else {
            winner = "First player";
            for (Integer integer : playerOneHand) {
                sum += integer;
            }
        }
        System.out.printf("%s wins! Sum: %d", winner, sum);
    }

    private static boolean isEmpty(List<Integer> playerOneHand, List<Integer> playerTwoHand) {
        return playerOneHand.isEmpty() || playerTwoHand.isEmpty();
    }


}
