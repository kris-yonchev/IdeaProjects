package SetsAndMapsAdvancedExercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Set<String>> map = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String name = input.split(": ")[0];
            String cards = input.split(": ")[1];
            String[] cardsArr = cards.split(", ");
            Set<String> drawnCards = new HashSet<>();
            Collections.addAll(drawnCards, cardsArr);


            map.putIfAbsent(name, drawnCards);
            Set<String> currentDrawnCards = map.get(name);
            currentDrawnCards.addAll(drawnCards);
            map.put(name, currentDrawnCards);


            input = scanner.nextLine();
        }
        map.entrySet().stream().forEach(entry -> {
            String name = entry.getKey();
            Set<String> cards = entry.getValue();
            int points = getPoints(cards);
            System.out.printf("%s: %d\n", name, points);
        });

    }

    private static int getPoints(Set<String> cards) {
        Map<Character, Integer> pointMap = getCardValues();
        int sum = 0;
        for (String card : cards) {
            int points = 0;
            if (card.contains("10")) {
                char multiplier = card.charAt(2);
                points = 10 * pointMap.get(multiplier);
            } else {
                char multiplier = card.charAt(1);
                char number = card.charAt(0);
                points = pointMap.get(number) * pointMap.get(multiplier);
            }
            sum += points;
        }
        return sum;
    }

    private static Map<Character, Integer> getCardValues() {
        Map<Character, Integer> values = new HashMap<>();
        values.put('2', 2);
        values.put('3', 3);
        values.put('4', 4);
        values.put('5', 5);
        values.put('6', 6);
        values.put('7', 7);
        values.put('8', 8);
        values.put('9', 9);
        values.put('J', 11);
        values.put('Q', 12);
        values.put('K', 13);
        values.put('A', 14);
        values.put('S', 4);
        values.put('H', 3);
        values.put('D', 2);
        values.put('C', 1);
        return values;
    }

}
