package workingWtihAbstractionExercise.cardsWithPower;

public class Card {
    public Rank rank;
    public Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getPower() {
        return this.rank.getValue() + this.suit.getValue();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", rank.name(), suit.name(), getPower());
    }
}
