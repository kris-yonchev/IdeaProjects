package SetsAndMapsAdvancedExercise;

import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Character, Integer> map = new TreeMap<>();
        String text = scanner.nextLine();
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            map.putIfAbsent(symbol, 0);
            map.put(symbol, map.get(symbol) + 1);
        }
        map.forEach((key, value) -> System.out.printf("%c: %d time/s\n", key, value));
    }
}
