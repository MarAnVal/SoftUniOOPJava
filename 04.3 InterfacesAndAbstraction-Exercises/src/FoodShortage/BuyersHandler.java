package FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BuyersHandler implements CommandHandler {
    private HashMap<String, Buyer> buyers;
    private int numBuyer;
    private Scanner scanner;
    private String endCommand;

    public BuyersHandler(String endCommand) {
        this.scanner = new Scanner(System.in);
        this.numBuyer = Integer.parseInt(this.scanner.nextLine());
        this.buyers = new HashMap<>();
        this.endCommand = endCommand;
    }

    @Override
    public void readCommand() {
        for (int i = 0; i < numBuyer; i++) {
            String[] parts = this.scanner.nextLine().split("\\s+");
            Buyer buyer = null;
            switch (parts.length) {
                case 4:
                    buyer = new Citizen(parts[0],
                            Integer.parseInt(parts[1]), parts[2], parts[3]);
                    break;
                case 3:
                    buyer = new Rebel(parts[0], Integer.parseInt(parts[1]), parts[2]);
                    break;
            }
            if (buyer != null) {
                buyers.put(parts[0], buyer);
            }
        }
    }

    @Override
    public void processCommand() {
        String personName = this.scanner.nextLine();
        while (!personName.equals(endCommand)) {
            if(buyers.containsKey(personName)){
                Buyer buyer = buyers.get(personName);
                buyer.buyFood();
            }
            personName = this.scanner.nextLine();
        }
    }

    @Override
    public void executeCommand() {
        int boughtFood = 0;
        for (Map.Entry<String, Buyer> person : buyers.entrySet()) {
            boughtFood += person.getValue().getFood();
        }
        System.out.println(boughtFood);
    }
}
