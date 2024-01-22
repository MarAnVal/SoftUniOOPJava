package main.java.Exam_18_April_2022.Zoo.entities.foods;

public abstract class BaseFood implements Food{
    //calories - int
    private int calories;
    //price - double
    private double price;

    public BaseFood(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }

    @Override
    public int getCalories() {
        return this.calories;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
