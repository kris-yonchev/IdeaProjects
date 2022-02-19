package LastExamPrep;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> plants = new HashMap<>();
        Map<String, List<Double>> rating = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split("<->");
            String plant = info[0];
            int rarity = Integer.parseInt(info[1]);
            plants.compute(plant, (k, v) -> rarity);
            rating.putIfAbsent(plant, new ArrayList<>());

        }

        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String[] tokens = input.split(": ");
            String command = tokens[0];
            String[] elements = tokens[1].split(" - ");
            String plantName = elements[0];
            if (!plants.containsKey(plantName)) {
                System.out.println("error");
                input=scanner.nextLine();
                continue;
            }
            switch (command) {
                case "Rate":
                    double rate = Double.parseDouble(elements[1]);
                    rating.get(plantName).add(rate);
                    break;
                case "Update":
                    int rarity = Integer.parseInt(elements[1]);
                    plants.compute(plantName, (k, v) -> rarity);
                    break;
                case "Reset":
                    rating.get(plantName).clear();
                    break;
                default:
                    System.out.println("error");
            }
            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition: ");
        plants.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().thenComparingDouble(x -> rating.get(x.getKey())
                        .stream()
                        .mapToDouble(Double::doubleValue)
                        .average().orElse(0.0))
                        .reversed())
                .forEach(e -> System.out.printf("- %s; Rarity: %d; Rating: %.2f\n", e.getKey(), e.getValue(), rating.get(e.getKey()).stream().mapToDouble(Double::doubleValue)
                        .average().orElse(0.0)));

    }
}
