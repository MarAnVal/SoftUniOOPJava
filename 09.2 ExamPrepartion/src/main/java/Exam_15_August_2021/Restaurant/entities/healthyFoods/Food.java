package main.java.Exam_15_August_2021.Restaurant.entities.healthyFoods;

import main.java.Exam_15_August_2021.Restaurant.entities.healthyFoods.interfaces.HealthyFood;

import static main.java.Exam_15_August_2021.Restaurant.common.ExceptionMessages.*;

public abstract class Food implements HealthyFood {
    //name - String
    private String name;
    //portion - double
    private double portion;
    //price - double
    private double price;

    public Food(String name, double portion, double price) {
        //If the name is null or whitespace, throw an IllegalArgumentException
        // with a message "Name cannot be null or white space!"
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
        //If the portion is less or equal to 0, throw an IllegalArgumentException
        // with a message "Portion cannot be less or equal to zero!"
        if (portion <= 0) {
            throw new IllegalArgumentException(INVALID_PORTION);
        }
        this.portion = portion;
        //If the price is less or equal to 0, throw an IllegalArgumentException
        // with a message "Price cannot be less or equal to zero!"
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
