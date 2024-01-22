package main.java.Exam_11_December_2021.CatHouse.entities.toys;

public abstract class BaseToy implements Toy{
    //softness - int
    private int softness;
    //price - double
    private double price;
    //The price of the toy.

    //(int softness, double price)
    public BaseToy(int softness, double price) {
        this.softness = softness;
        this.price = price;
    }

    @Override
    public int getSoftness() {
        return this.softness;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
