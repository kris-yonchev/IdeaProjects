import java.util.*;
import java.util.stream.Collectors;


public class RoyaleArena implements IArena {

    private Map<Integer, Battlecard> cardsById;
    private Map<CardType, Set<Battlecard>> cardsByTypes;


    public RoyaleArena() {
        this.cardsById = new LinkedHashMap<>();
        this.cardsByTypes = new LinkedHashMap<>();
    }

    @Override
    public void add(Battlecard card) {
        cardsById.putIfAbsent(card.getId(), card);
        this.cardsByTypes.putIfAbsent(card.getType(), new TreeSet<>(Battlecard::compareTo));
        this.cardsByTypes.get(card.getType()).add(card);
    }

    @Override
    public boolean contains(Battlecard card) {
        return cardsById.containsKey(card.getId());
    }

    @Override
    public int count() {
        return cardsById.size();
    }

    @Override
    public void changeCardType(int id, CardType type) {
        Battlecard battlecard = cardsById.get(id);
        if (battlecard == null) {
            throw new IllegalArgumentException();
        }
        battlecard.setType(type);
    }

    @Override
    public Battlecard getById(int id) {
        Battlecard battlecard = cardsById.get(id);
        if (battlecard == null) {
            throw new UnsupportedOperationException();
        }
        return battlecard;
    }

    @Override
    public void removeById(int id) {
        Battlecard battlecard = cardsById.remove(id);
        if (battlecard == null) {
            throw new UnsupportedOperationException();
        }
        cardsByTypes.get(battlecard.getType()).remove(battlecard);
    }

    @Override
    public Iterable<Battlecard> getByCardType(CardType type) {
        return getBattleCardsByType(type);
    }

    private Set<Battlecard> getBattleCardsByType(CardType type) {
        Set<Battlecard> battleCards = this.cardsByTypes.get(type);

        if (battleCards == null || battleCards.isEmpty()) {
            throw new UnsupportedOperationException();
        }
        return battleCards;
    }


    @Override
    public Iterable<Battlecard> getByTypeAndDamageRangeOrderedByDamageThenById(CardType type, int lo, int hi) {
        Set<Battlecard> battleCardsByType = getBattleCardsByType(type);

        List<Battlecard> result = battleCardsByType.stream()
                .filter(c -> c.getDamage() > lo && c.getDamage() < hi)
                .sorted(Battlecard::compareTo)
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new UnsupportedOperationException();
        }
        return result;
    }

    @Override
    public Iterable<Battlecard> getByCardTypeAndMaximumDamage(CardType type, double damage) {
        Set<Battlecard> battleCards = getBattleCardsByType(type);
        List<Battlecard> re = battleCards.stream()
                .filter(c -> c.getDamage() <= damage)
                .sorted(Battlecard::compareTo)
                .collect(Collectors.toList());
        if (re.isEmpty()) {
            throw new UnsupportedOperationException();
        }
        return re;
    }

    @Override
    public Iterable<Battlecard> getByNameOrderedBySwagDescending(String name) {
        List<Battlecard> battleCards = cardsById.values().stream()
                .filter(v -> v.getName().equals(name))
                .collect(Collectors.toList());

        if (battleCards.isEmpty()) {
            throw new UnsupportedOperationException();
        }

        battleCards
                .sort(Comparator.comparingDouble(Battlecard::getSwag)
                        .reversed().thenComparing(Battlecard::getId));
        return battleCards;
    }

    @Override
    public Iterable<Battlecard> getByNameAndSwagRange(String name, double lo, double hi) {
        List<Battlecard> battleCards = cardsById.values()
                .stream()
                .filter(v -> v.getName().equals(name) && v.getSwag() >= lo && v.getSwag() < hi)
                .collect(Collectors.toList());

        if (battleCards.isEmpty()) {
            throw new UnsupportedOperationException();
        }

        battleCards
                .sort(Comparator.comparingDouble(Battlecard::getSwag)
                        .reversed()
                        .thenComparing(Battlecard::getId));

        return battleCards;
    }

    @Override
    public Iterable<Battlecard> getAllByNameAndSwag() {
        Map<String, Battlecard> battleCards = new LinkedHashMap<>();
        for (Battlecard battlecard : cardsById.values()) {
            if (!battleCards.containsKey(battlecard.getName())) {
                battleCards.put(battlecard.getName(), battlecard);
            } else {
                double oldSwag = battleCards.get(battlecard.getName()).getSwag();
                double newSwag = battlecard.getSwag();

                if (newSwag > oldSwag) {
                    battleCards.put(battlecard.getName(), battlecard);
                }
            }
        }

        return battleCards.values();
    }

    @Override
    public Iterable<Battlecard> findFirstLeastSwag(int n) {
        if (n > this.count()) {
            throw new UnsupportedOperationException();
        }

        List<Battlecard> battlecards = cardsById.values().stream().sorted(Comparator.comparingDouble(Battlecard::getSwag)).collect(Collectors.toList());

        return battlecards.stream().limit(n)
                .sorted(Comparator.comparingDouble(Battlecard::getSwag).thenComparingInt(Battlecard::getId)).collect(Collectors.toList());

    }

    @Override
    public Iterable<Battlecard> getAllInSwagRange(double lo, double hi) {
        return cardsById.values().stream()
                .filter(v -> v.getSwag() <= hi && v.getSwag() >= lo)
                .sorted(Comparator.comparingDouble(Battlecard::getSwag))
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Battlecard> iterator() {
        return this.cardsById.values().iterator();
    }
}
