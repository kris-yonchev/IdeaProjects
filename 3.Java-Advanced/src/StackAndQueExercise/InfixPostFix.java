package StackAndQueExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixPostFix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> numQue = new ArrayDeque<>();
        ArrayDeque<String> opStack = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");

        for (String in : input) {
            if (Character.isDigit(in.charAt(0)) || Character.isLetter(in.charAt(0))) {
                numQue.offer(in);
            } else {
                if (opStack.isEmpty()) {
                    opStack.push(in);
                } else {
                    String lastOperand = opStack.peek();

                    switch (in) {
                        case "+":
                        case "-":
                            if (!lastOperand.equals("(")) {
                                numQue.offer(opStack.pop());
                            }
                            opStack.push(in);
                            break;
                        case "*":
                        case "/":
                            if (lastOperand.equals("*") || lastOperand.equals("/")) {
                                numQue.offer(opStack.pop());
                            }
                            opStack.push(in);
                            break;
                        case "(":
                            opStack.push(in);
                            break;
                        case ")":
                            while (!opStack.peek().equals("(")) {
                                numQue.offer(opStack.pop());
                            }
                            opStack.pop();
                            break;
                    }
                }
            }
        }

        while (!numQue.isEmpty()) {
            System.out.print(numQue.poll() + " ");
        }
        while (!opStack.isEmpty()) {
            System.out.print(opStack.pop() + " ");
        }

    }
}
