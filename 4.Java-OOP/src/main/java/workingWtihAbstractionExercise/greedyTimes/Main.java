package workingWtihAbstractionExercise.greedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] items = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(bagCapacity);

        for (int i = 0; i < items.length; i += 2) {
            String itemType = items[i];
            long currentAmount = Long.parseLong(items[i + 1]);

            if (itemType.length() == 3) {
                bag.addCash(itemType, currentAmount);
            } else if (itemType.toLowerCase().endsWith("gem")) {
                bag.addGems(itemType, currentAmount);
            } else if (itemType.equalsIgnoreCase("gold")) {
                bag.addGold(currentAmount);
            }

        }
            System.out.println(bag.sorted());
    }
}