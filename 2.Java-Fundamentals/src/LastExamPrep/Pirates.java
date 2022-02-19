package LastExamPrep;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> cityPopulation = new TreeMap<>();
        Map<String, Integer> cityGold = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Sail")) {
            String[] inputSplit = input.split("\\|\\|");
            String name = inputSplit[0];
            int population = Integer.parseInt(inputSplit[1]);
            int gold = Integer.parseInt(inputSplit[2]);
            if (cityPopulation.containsKey(name)) {
                cityPopulation.put(name, cityPopulation.get(name) + population);
                cityGold.put(name, cityGold.get(name) + gold);
            }
            cityPopulation.putIfAbsent(name, population);
            cityGold.putIfAbsent(name, gold);
            input = scanner.nextLine();
        }
        while (!input.equals("End")) {
            String[] inputSplit = input.split("=>");
            switch (inputSplit[0]) {
                case "Plunder":
                    String name = inputSplit[1];
                    int pop = Integer.parseInt(inputSplit[2]);
                    int gold = Integer.parseInt(inputSplit[3]);
                    if (cityPopulation.containsKey(name)) {
                        cityPopulation.put(name, cityPopulation.get(name) - pop);
                        cityGold.put(name, cityGold.get(name) - gold);
                    }
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n", name, gold, pop);
                    if (cityPopulation.get(name) <= 0 || cityGold.get(name) <= 0) {
                        cityPopulation.remove(name);
                        cityGold.remove(name);
                        System.out.printf("%s has been wiped off the map!\n", name);
                    }
                    break;
                case "Prosper":
                    String prosperTown = inputSplit[1];
                    int prosperGold = Integer.parseInt(inputSplit[2]);
                    if (prosperGold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    } else {
                        if (cityGold.containsKey(prosperTown)) {
                            cityGold.put(prosperTown, cityGold.get(prosperTown) + prosperGold);
                            System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n", prosperGold, prosperTown, cityGold.get(prosperTown));
                        }
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to: \n", cityGold.size());
        cityGold.entrySet()
                .stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> {
                    int cityPop = cityPopulation.get(e.getKey());
                    System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n", e.getKey(), cityPop, e.getValue());

                });
    }
}
