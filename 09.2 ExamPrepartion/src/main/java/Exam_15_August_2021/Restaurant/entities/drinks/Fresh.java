package main.java.Exam_15_August_2021.Restaurant.entities.drinks;

public class Fresh extends BaseBeverage{
    //constant value for freshPrice - 3.50
    private static final double FRESH_PRICE = 3.5;
    public Fresh(String name, int counter, String brand) {
        super(name, counter, FRESH_PRICE, brand);
    }
}
