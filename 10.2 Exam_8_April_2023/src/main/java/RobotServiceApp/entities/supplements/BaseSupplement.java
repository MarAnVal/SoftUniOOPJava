package main.java.RobotServiceApp.entities.supplements;

public abstract class BaseSupplement implements Supplement{
    //hardness - int
    private int hardness;
    //price - double
    private double price;
    //The price of the supplements that the service offers.

    //(int hardness, double price)

    public BaseSupplement(int hardness, double price) {
        this.hardness = hardness;
        this.price = price;
    }

    @Override
    public int getHardness() {
        return this.hardness;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
