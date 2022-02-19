package ExamPrep.MagicBox;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> que = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(stack::push);


        int sum = 0;
        while (!stack.isEmpty() && !que.isEmpty()) {
            int one = que.peek();
            int two = stack.pop();
            int current = one + two;
            if (current % 2 == 0) {
                sum += current;
                que.poll();
            } else {

                que.offer(two);
            }
        }

        if (que.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else if (stack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        if (sum >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + sum);
        } else {
            System.out.println("Poor prey... Value: " + sum);
        }
    }
}
