
package GreedyTimes;
//workingWithAbstraction.

import java.util.*;

public class MainNEW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bag bag = createBag(scanner);
        List<Item> items = getWorthItems(scanner);


        for (int i = 0; i < items.size(); i += 2) {
            Item currentItem = items.get(i);
            bag.putInIfFit(currentItem);
        }
        printBag(bag);
    }

    private static void printBag(Bag bag) {
        //todo
    }

    private static Bag createBag(Scanner scanner) {
        long bagCapacity = Long.parseLong(scanner.nextLine());
        return new Bag(bagCapacity);
    }

    private static List<Item> getWorthItems(Scanner scanner) {
        List<Item> list = new ArrayList<>();
        String[] items = scanner.nextLine().split("\\s+");
        for (int i = 0; i < items.length - 1; i+=2) {
            String name = items[i];
            long quantity = Long.parseLong(items[i + 1]);
            Item item = new Item(name, quantity);
            if (item.getType() != null) {
                list.add(item);
            }
        }
        return list;
    }
}