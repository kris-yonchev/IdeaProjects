package StackAndQueExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] input = scanner.nextLine().split("\\s+");
        Arrays.stream(input).forEach(stack::push);
        stack.forEach(e -> System.out.printf("%s ", e));


    }
}
