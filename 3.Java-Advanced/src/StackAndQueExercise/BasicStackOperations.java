package StackAndQueExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] numbers = scanner.nextLine().split("\\s+");
        int numberOfElements = Integer.parseInt(input[0]);
        Arrays.stream(numbers).limit(numberOfElements).forEach(stack::push);
        int popCount = Integer.parseInt(input[1]);
        for (int i = 0; i < popCount; i++) {
            stack.pop();
        }
        String element = input[2];
        if (stack.contains(element)) {
            System.out.println("true");
        } else if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(Collections.min(stack));
        }

    }
}
