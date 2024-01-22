package main.java.Exam_15_August_2021.Restaurant.entities.healthyFoods;

public class Salad extends Food{
    // constant value for InitialSaladPortion – 150.
    private static final double INITIAL_SALAD_PORTION = 150;
    public Salad(String name, double price) {
        super(name, INITIAL_SALAD_PORTION, price);
    }
}
