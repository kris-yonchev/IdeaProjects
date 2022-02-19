package StackAndQue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (num==0) {
            System.out.println(0);
            return;
        }
        while (num >= 1) {
            stack.push(num % 2);
            num /= 2;
        }

        for (int digit : stack) {
            System.out.print(digit);
        }
    }
}
