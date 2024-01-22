package FoodShortage;

public class Main {
    public static void main(String[] args) {
        BuyersHandler buyersHandler = new BuyersHandler("End");
        buyersHandler.readCommand();
        buyersHandler.processCommand();
        buyersHandler.executeCommand();
    }
}
