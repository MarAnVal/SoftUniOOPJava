package GreedyTimes;

import java.util.LinkedHashMap;
import java.util.List;

public class Bag {
    private final long bagCapacity;
    private LinkedHashMap<String, List<Item>> bagMap;
    private long gold;
    private long gems;
    private long money;

    public Bag(long bagCapacity) {
        this.bagCapacity = bagCapacity;
        bagMap = new LinkedHashMap<>();
        gold = 0;
        gems = 0;
        money = 0;

    }

    public void putInIfFit(Item item) {
        //check if item fit in the bag
        //change gold, gems or money; put the item in the bagMap
    }

    public long getBagCapacity() {
        return bagCapacity;
    }

    public LinkedHashMap<String, List<Item>> getBagMap() {
        return bagMap;
    }

    public long getGold() {
        return gold;
    }

    public long getGems() {
        return gems;
    }

    public long getMoney() {
        return money;
    }

    public long allInIt(){
        return gold + gems + money;
    }
}
