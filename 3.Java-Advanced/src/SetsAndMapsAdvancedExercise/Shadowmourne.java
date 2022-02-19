package SetsAndMapsAdvancedExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Shadowmourne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> legMats = new TreeMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();
        legMats.put("shards", 0);
        legMats.put("fragments", 0);
        legMats.put("motes", 0);
        String lego = "";
        while (lego.equals("")) {
            String[] mats = scanner.nextLine().split(" ");
            for (int i = 0; i < mats.length - 1; i += 2) {
                int amount = Integer.parseInt(mats[i]);
                String material = mats[i + 1].toLowerCase();
                if (isLegendaryMat(material)) {
                    legMats.put(material, legMats.get(material) + amount);
                    if (legMats.get(material) >= 250) {
                        switch (material) {
                            case "shards":
                                lego = "Shadowmourne";
                                break;
                            case "motes":
                                lego = "Dragonwrath";
                                break;
                            case "fragments":
                                lego = "Valanyr";
                                break;
                        }
                        legMats.put(material, legMats.get(material) - 250);
                        break;
                    }

                } else {
                    if (!junk.containsKey(material)) {
                        junk.put(material, amount);
                    } else {
                        junk.put(material, junk.get(material) + amount);
                    }
                }
            }

        }
        System.out.println(lego + " obtained!");
        legMats
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(stringIntegerEntry -> System.out.printf("%s: %d\n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue()));
        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }

    private static boolean isLegendaryMat(String material) {
        return material.equals("shards") || material.equals("fragments") || material.equals("motes");
    }

}
