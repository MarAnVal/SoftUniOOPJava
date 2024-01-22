package main.java.Exam_15_August_2021.Restaurant.entities.healthyFoods;

public class VeganBiscuits extends Food{
    //constant value for InitialVeganBiscuitsPortion – 205.
    private static final double INITIAL_VEGANBUISCUITS_PORTION = 205;
    public VeganBiscuits(String name, double price) {
        super(name, INITIAL_VEGANBUISCUITS_PORTION, price);
    }
}
