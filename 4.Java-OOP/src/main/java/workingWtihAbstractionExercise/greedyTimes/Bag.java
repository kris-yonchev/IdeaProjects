package workingWtihAbstractionExercise.greedyTimes;


import java.util.HashMap;
import java.util.Map;

public class Bag {
    private final long capacity;
    private long currentCapacity;
    private Long gold;
    private final Map<String, Long> gems;
    private final Map<String, Long> cash;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.currentCapacity = 0;
        this.gems = new HashMap<>();
        this.cash = new HashMap<>();
    }

    public void addGold(long amount) {
        if (hasCapacity(amount)) {
            gold = gold == null ? amount : gold + amount;
            this.currentCapacity += amount;
        }
    }

    public void addGems(String item, long amount) {
        if (gold != null && getSum(gems) + amount <= gold && hasCapacity(amount)) {
            gems.put(item, !gems.containsKey(item) ? amount : gems.get(item) + amount);
            this.currentCapacity += amount;
        }
    }

    public void addCash(String item, long amount) {
        if (getSum(cash) + amount <= getSum(gems) && hasCapacity(amount)) {
            cash.put(item, !cash.containsKey(item) ? amount : cash.get(item) + amount);
            this.currentCapacity += amount;
        }
    }

    public String sorted() {
        StringBuilder sb = new StringBuilder();
        if (gold != null) {
            sb.append(String.format("<Gold> $%d\n##Gold - %d\n", gold, gold));
        }
        if (!gems.isEmpty()) {
            sb.append(String.format("<Gem> $%d\n", getSum(gems)));
            gems.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByKey().reversed().thenComparingLong(Map.Entry::getValue))
                    .forEach(e -> sb.append(String.format("##%s - %d\n", e.getKey(), e.getValue())));
        }
        if (!cash.isEmpty()) {
            sb.append(String.format("<Cash> $%d\n", getSum(cash)));
            cash.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByKey().reversed().thenComparingLong(Map.Entry::getValue))
                    .forEach(e -> sb.append(String.format("##%s - %d\n", e.getKey(), e.getValue())));
        }

        return sb.toString().trim();
    }


    private long getSum(Map<String, Long> map) {
        return map.values().stream().mapToLong(e -> e).sum();
    }

    private boolean hasCapacity(long amount) {
        return capacity >= currentCapacity + amount;
    }

}
