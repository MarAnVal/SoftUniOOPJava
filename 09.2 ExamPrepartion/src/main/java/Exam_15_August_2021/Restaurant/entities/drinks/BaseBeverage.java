package main.java.Exam_15_August_2021.Restaurant.entities.drinks;

import main.java.Exam_15_August_2021.Restaurant.entities.drinks.interfaces.Beverages;

import static main.java.Exam_15_August_2021.Restaurant.common.ExceptionMessages.*;

public abstract class BaseBeverage implements Beverages {
    //name - String
    private String name;
    //counter - int
    private int counter;
    //price - double
    private double price;
    //brand - String
    private String brand;

    public BaseBeverage(String name, int counter, double price, String brand) {
        //If the name is null or whitespace, throw an IllegalArgumentException
        // with the message "Name cannot be null or white space!"
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
        //If the counter is less or equal to 0, throw an IllegalArgumentException
        // with the message "Counter cannot be less or equal to zero!"
        if (counter <= 0) {
            throw new IllegalArgumentException(INVALID_COUNTER);
        }
        this.counter = counter;
        //If the price is less or equal to 0, throw an IllegalArgumentException
        // with the message "Price cannot be less or equal to zero!"
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
        //If the brand is null or whitespace, throw an IllegalArgumentException
        // with the message "Brand cannot be null or white space!"
        if (brand == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_BRAND);
        }
        this.brand = brand;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCounter() {
        return this.counter;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }
}
