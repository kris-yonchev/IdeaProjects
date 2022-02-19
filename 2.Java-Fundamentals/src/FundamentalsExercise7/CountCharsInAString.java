package FundamentalsExercise7;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        LinkedHashMap<Character, Integer> counts = new LinkedHashMap<>();
        for (String inpu : input) {
            for (int i = 0; i < inpu.length(); i++) {
                char symbol = inpu.charAt(i);
                if (!counts.containsKey(symbol)) {
                    counts.put(symbol, 0);
                }
                counts.put(symbol, counts.get(symbol) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            System.out.printf("%c -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
