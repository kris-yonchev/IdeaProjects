package StackAndQue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> que = new ArrayDeque<>();
        for (String kid : kids) {
            que.offer(kid);
        }
        int cycle = 1;
        while (que.size() > 1) {
            for (int i = 1; i < n; i++) {
                que.offer(que.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + que.peek());
            } else {
                System.out.println("Removed " + que.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + que.poll());
    }

    private static boolean isPrime(int cycle) {
        if (cycle <= 1) {
            return false;
        }
        for (int i = 2; i < cycle; i++) {
            if (cycle % i == 0) {
                return false;
            }
        }
        return true;
    }
}
