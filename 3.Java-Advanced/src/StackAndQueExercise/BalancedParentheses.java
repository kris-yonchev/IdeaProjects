package StackAndQueExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        boolean balanced = false;
        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (symbol == '[' || symbol == '{' || symbol == '(') {
                openBrackets.push(symbol);
            } else if (symbol == ']' || symbol == '}' || symbol == ')') {
                if (openBrackets.isEmpty()) {
                    balanced = false;
                    break;
                }
                char lastOpenBracket = openBrackets.pop();
                if (lastOpenBracket == '{' && symbol == '}') {
                    balanced = true;
                } else if (lastOpenBracket == '[' && symbol == ']') {
                    balanced = true;
                } else if (lastOpenBracket == '(' && symbol == ')') {
                    balanced = true;
                } else {
                    balanced = false;
                    break;
                }
            }
        }
        if (balanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
