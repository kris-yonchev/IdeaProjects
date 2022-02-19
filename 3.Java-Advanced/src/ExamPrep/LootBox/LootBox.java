package ExamPrep.LootBox;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> que = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(stack::push);

        int totalSum = 0;

        while (!que.isEmpty() && !stack.isEmpty()) {
            int one = que.peek();
            int two = stack.pop();
            int sum = one + two;

            if (sum % 2 == 0) {
                totalSum += sum;
                que.poll();
            } else {
                que.offer(two);
            }
        }

        if (que.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }
        if (totalSum >= 100) {
            System.out.println("Your loot was epic! Value: " + totalSum);
        } else {
            System.out.println("Your loot was poor... Value: " + totalSum);
        }

    }
}
