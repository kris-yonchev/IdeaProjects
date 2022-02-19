package SetsAndMapsAdvanced;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String continent = info[0];
            String country = info[1];
            String city = info[2];


            map.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> newMap = map.get(continent);
            newMap.putIfAbsent(country, new ArrayList<>());
            newMap.get(country).add(city);
        }
        map.entrySet().stream().forEach(entry -> {
            System.out.printf("%s:\n", entry.getKey());
            entry.getValue().entrySet().stream().forEach(e -> {
                System.out.printf("  %s -> %s\n", e.getKey(), String.join(", ", e.getValue()));
            });
        });
    }
}
