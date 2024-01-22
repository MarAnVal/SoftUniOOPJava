package main.java.Exam_15_August_2021.Restaurant.entities.drinks;

public class Smoothie extends BaseBeverage {
    //constant value for smoothiePrice - 4.50
    private static final double SMOOTHIE_PRICE = 3.5;
    public Smoothie(String name, int counter, String brand) {
        super(name, counter, SMOOTHIE_PRICE, brand);
    }
}
