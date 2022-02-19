package Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> que = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(stack::push);

        int sour = 0;
        int harvest = 0;
        int hirny = 0;
        int fashion = 0;

        while (!que.isEmpty() && !stack.isEmpty()) {
            int one = que.peek();
            int two = stack.peek();
            int sum = one * two;
            if (one == 0) {
                que.poll();
                continue;
            }
            if (sum == 150) {
                sour++;
                que.poll();
                stack.pop();
            } else if (sum == 250) {
                harvest++;
                que.poll();
                stack.pop();
            } else if (sum == 300) {
                hirny++;
                que.poll();
                stack.pop();
            } else if (sum == 400) {
                fashion++;
                que.poll();
                stack.pop();
            } else {
                stack.pop();
                que.offer(que.peek() + 5);
                que.poll();

            }
        }

        if (harvest > 0 && hirny > 0 && fashion > 0 && sour > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!que.isEmpty()) {
            int output = que.stream().mapToInt(e -> e).sum();
            System.out.println("Ingredients left: " + output);
        }
        if (hirny > 0) {
            System.out.printf("# Apple Hinny --> %d\n", hirny);
        }
        if (fashion > 0) {
            System.out.printf("# High Fashion --> %d\n", fashion);
        }
        if (sour > 0) {
            System.out.printf("# Pear Sour --> %d\n", sour);
        }
        if (harvest > 0) {
            System.out.printf("# The Harvest --> %d", harvest);
        }
    }
}
