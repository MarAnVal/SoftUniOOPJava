package GreedyTimes;

public class Item {
    enum Type {
        GOLD,
        CASH,
        GEM;
    }

    private String name;
    private Type type;
    private long quantity;

    public Item(String name, long quantity) {
            this.name = name;
            this.type = whatTypeItemItIs(name);
            this.quantity = quantity;
    }

    public Type whatTypeItemItIs(String name) {
        if (name.length() == 3) {
            return Type.valueOf("CASH");
        } else if (name.toLowerCase().endsWith("gem")) {
            return Type.valueOf("GEM");
        } else if (name.toLowerCase().equals("gold")) {
            return Type.valueOf("GOLD");
        }
       return null;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return this.type;
    }

    public long getQuantity() {
        return this.quantity;
    }
}
