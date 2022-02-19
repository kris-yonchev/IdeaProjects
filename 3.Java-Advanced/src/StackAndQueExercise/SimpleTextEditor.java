package StackAndQueExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]) {
                case "1":
                    String stringToAppend = command[1];
                    text.append(stringToAppend);
                    stack.push(text.toString());
                    break;
                case "2":
                    for (int j = 0; j < Integer.parseInt(command[1]); j++) {
                        text.deleteCharAt(text.length() - 1);
                    }
                    stack.push(text.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(command[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    if (stack.size()>1) {
                        stack.pop();
                        text = new StringBuilder(stack.peek());
                    } else {
                        text = new StringBuilder();
                    }
                    break;
            }
        }
    }
}
