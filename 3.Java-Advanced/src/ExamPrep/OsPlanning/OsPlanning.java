package ExamPrep.OsPlanning;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OsPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(stack::push);

        ArrayDeque<Integer> que = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int toKill = Integer.parseInt(scanner.nextLine());

        boolean isKilled = false;

        while (!isKilled) {

            int thread = que.peek();
            int task = stack.peek();

            if (task == toKill) {
                isKilled = true;
                break;
            }
            que.poll();
            if (thread >= task) {
                stack.pop();

            }

        }

        System.out.printf("Thread with value %d killed task %d\n", que.peek(), toKill);
        for (int i : que) {
            System.out.print(i + " ");
        }
    }
}
