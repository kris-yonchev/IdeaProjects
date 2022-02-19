package ExamPrep.Cooking;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> que = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(stack::push);

        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;

        while (!que.isEmpty() && !stack.isEmpty()) {
            int one = que.poll();
            int two = stack.peek();
            int sum = one + two;

            if (sum == 25) {
                bread++;
                stack.pop();
            } else if (sum == 50) {
                cake++;
                stack.pop();
            } else if (sum == 75) {
                pastry++;
                stack.pop();
            } else if (sum == 100) {
                fruitPie++;
                stack.pop();
            } else {
                stack.pop();
                stack.push(two + 3);
            }
        }

        if (bread > 0 && cake > 0 && pastry > 0 && fruitPie > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        if (que.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            String output = que.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Liquids left: " + output);
        }
        if (stack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            String output = stack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Ingredients left: " + output);
        }

        System.out.printf("Bread: %d\nCake: %d\nFruit Pie: %d\nPastry: %d", bread, cake, fruitPie, pastry);
    }
}
