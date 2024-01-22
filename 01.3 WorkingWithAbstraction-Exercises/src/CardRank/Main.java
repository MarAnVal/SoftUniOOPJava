package CardRank;

public class Main {
    public static void main(String[] args) {
        CardRank[] values = CardRank.values();
        System.out.println("Card Ranks:");
        for (CardRank value : values) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value.name());
        }
    }
}
