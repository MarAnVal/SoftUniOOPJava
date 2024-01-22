package main.java.Exam_11_December_2021.CatHouse.entities.cat;

import static main.java.Exam_11_December_2021.CatHouse.common.ExceptionMessages.*;

public abstract class BaseCat implements Cat{
    //name - String
    private String name;
    //breed -  String
    private String breed;
    //kilograms -  int
    private int kilograms;
    //price - double
    private double price;

    //(String name, String breed, double price)

    public BaseCat(String name, String breed, int kilograms, double price) {
        setName(name);
        //If the breed is null or whitespace, throw a NullPointerException with a message:
        //"Cat breed cannot be null or empty."
        if(breed==null||breed.trim().isEmpty()){
            throw new NullPointerException(CAT_BREED_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.breed = breed;
        this.kilograms = kilograms;
        //The price of the Cat.
        //If the price is below or equal to 0, throw an IllegalArgumentException with a message:
        // "Cat price cannot be below or equal to 0."
        if(price <= 0){
            throw new IllegalArgumentException(CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        //If the name is null or whitespace, throw a NullPointerException with a message:
        //"Cat name cannot be null or empty."
        if(name == null||name.trim().isEmpty()){
            throw new NullPointerException (CAT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void eating() {
        this.kilograms= this.kilograms + 1;
    }

    @Override
    public int getKilograms() {
        return this.kilograms;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
