package StackAndQue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> que = new ArrayDeque<>();
        for (String kid : kids) {
            que.offer(kid);
        }
        while (que.size() > 1) {
            for (int i = 1; i < n; i++) {
                que.offer(que.poll());
            }
            System.out.println("Removed " + que.poll());
        }
        System.out.println("Last is " + que.poll());

    }
}
