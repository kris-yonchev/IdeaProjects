package StackAndQue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> que = new ArrayDeque<>();

        while (!input.equals("print")) {
            if (!input.equals("cancel")) {
                que.offer(input);
            } else {
                if (que.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String removed = que.poll();
                    System.out.println("Canceled " + removed);
                }
            }

            input = scanner.nextLine();
        }
        for (String q : que) {
            System.out.println(q);
        }
    }
}
