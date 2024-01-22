package CardsWithPower;

public class Card {
    private CardRank cardRank;
    private CardSuit cardSuit;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    private int getPower() {
        int powerRank = this.cardRank.getPowerRank();
        int powerSuit = this.cardSuit.getPowerSuit();

        return powerRank + powerSuit;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.cardRank, this.cardSuit, this.getPower());
    }
}
