package StackAndQue;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] expression = scanner.nextLine().split("\\s+");

        Collections.addAll(stack, expression);

        while (stack.size() > 1) {
            int firstInt = Integer.parseInt(stack.pop());
            String symbol = stack.pop();
            int secondInt = Integer.parseInt(stack.pop());

            switch (symbol) {
                case "+":
                    stack.push(String.valueOf(firstInt + secondInt));
                    break;
                case "-":
                    stack.push(String.valueOf(firstInt - secondInt));
                    break;
            }
        }
        System.out.println(stack.peek());
    }
}
