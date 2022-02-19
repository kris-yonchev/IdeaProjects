package StackAndQueExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(bib(n, new HashMap<>()));

    }

    private static long bib(int n, Map<Integer, Long> cache) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        long x = bib(n - 1, cache) + bib(n - 2, cache);
        cache.put(n, x);
        return x;

    }
}
