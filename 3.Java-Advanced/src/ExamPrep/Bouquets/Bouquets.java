package ExamPrep.Bouquets;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> tullStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(tullStack::push);

        ArrayDeque<Integer> daffQue = Arrays
                .stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int bouquets = 0;
        int bonus = 0;

        while (!daffQue.isEmpty() && !tullStack.isEmpty()) {
            int one = tullStack.peek();
            int two = daffQue.peek();
            int sum = one + two;

            while (sum > 15) {
                int currentValue = tullStack.peek();
                tullStack.pop();
                tullStack.push(currentValue - 2);
                sum = two + tullStack.peek();
            }
            if (sum == 15) {
                bouquets++;
            } else {
                bonus += sum;
            }
            daffQue.poll();
            tullStack.pop();
        }

        while (bonus >= 15) {
            bouquets++;
            bonus -= 15;
        }

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!\n", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }
}
