package StackAndQue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> back = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (back.size()<2) {
                    System.out.println("no previous URLs");
                } else {
                    String current = back.pop();
                    forward.push(current);
                    System.out.println(back.peek());
                }
            } else if (input.equals("forward")) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    String current = forward.pop();
                    System.out.println(current);
                    back.push(current);
                }
            } else {
                back.push(input);
                System.out.println(input);
                forward.clear();
            }


            input = scanner.nextLine();
        }
    }
}
