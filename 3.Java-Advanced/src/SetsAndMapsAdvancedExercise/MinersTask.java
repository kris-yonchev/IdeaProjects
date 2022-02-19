package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinersTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, Long> map = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            String resource = input;
            long amount = Integer.parseInt(scanner.nextLine());

            if (!map.containsKey(resource)) {
                map.put(resource, amount);
            } else {
                map.put(resource, map.get(resource) + amount);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
