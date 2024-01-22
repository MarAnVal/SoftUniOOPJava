package main.java.Exam_15_August_2021.Restaurant.entities.tables;

import main.java.Exam_15_August_2021.Restaurant.entities.drinks.interfaces.Beverages;
import main.java.Exam_15_August_2021.Restaurant.entities.healthyFoods.interfaces.HealthyFood;
import main.java.Exam_15_August_2021.Restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static main.java.Exam_15_August_2021.Restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static main.java.Exam_15_August_2021.Restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {
    //healthyFood - Collection<HealthyFood> accessible only by the base class
    private Collection<HealthyFood> healthyFood;
    //beverages – Collection<Beverages> accessible only by the base class
    private Collection<Beverages> beverages;
    //number – int the table number
    private int number;
    //size - int the table size
    private int size;
    //numberOfPeople - int the counter of people who want a table
    private int numberOfPeople;
    //pricePerPerson - double the price per person for the table
    private double pricePerPerson;
    //isReservedTable - boolean returns true if the table is reserved, otherwise false
    private boolean isReservedTable;
    //allPeople - double calculates the price for all people
    private double allPeople;

    //(int number, int size, double pricePerPerson)

    public BaseTable(int number, int size, double pricePerPerson) {
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.number = number;
        //It can’t be less than zero. In these cases, throw an
        // IllegalArgumentException with the message "Size has to be greater than 0!"
        if (size <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
        this.numberOfPeople = 0;
        this.pricePerPerson = pricePerPerson;
        this.isReservedTable = false;
        this.allPeople = 0.0;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        //It can’t be less than or equal to 0. In these cases, throw an
        // IllegalArgumentException with the message "Cannot place zero or less people!"
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        //Reserves the table with the counter of people given.
        this.numberOfPeople = numberOfPeople;
        this.isReservedTable = true;
        //FIXME
        this.allPeople = numberOfPeople * pricePerPerson;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        //FIXME
        double bill = this.allPeople;
        for (Beverages beverage : this.beverages) {
            bill+=beverage.getPrice();
        }
        for (HealthyFood food : healthyFood) {
            bill+=food.getPrice();
        }
        return bill;
    }

    @Override
    public void clear() {
        this.healthyFood.clear();
        this.beverages.clear();
        this.numberOfPeople = 0;
        this.allPeople = 0;
        this.isReservedTable = false;
    }

    @Override
    public String tableInformation() {
        StringBuffer text= new StringBuffer();
        //Return a String with the following format:
        //"Table - {table number}
        text.append(String.format("Table - %d", this.number));
        text.append(System.lineSeparator());
        //Size - {table size}
        text.append(String.format("Size - %d", this.size));
        text.append(System.lineSeparator());
        //Type - {table type}
        text.append(String.format("Type - %s", this.getClass().getSimpleName()));
        text.append(System.lineSeparator());
        //All price - {price per person for the current table}"
        text.append(String.format("All price - %.2f", this.pricePerPerson));
        return null;
    }

}
