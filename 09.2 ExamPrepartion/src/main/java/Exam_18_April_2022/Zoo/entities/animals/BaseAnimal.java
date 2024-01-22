package main.java.Exam_18_April_2022.Zoo.entities.animals;

import static main.java.Exam_18_April_2022.Zoo.common.ExceptionMessages.*;

public abstract class BaseAnimal implements Animal {
    //name - String
    private String name;
    //kind -  String
    private String kind;
    //kg -  double
    private double kg;
    //price - double
    private double price;

    public BaseAnimal(String name, String kind, double kg, double price) {
        //If the name is null or whitespace, throw a NullPointerException with a message:
        //"Animal name cannot be null or empty."
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ANIMAL_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
        //If the type is null or whitespace, throw a NullPointerException with a message:
        //"Animal kind cannot be null or empty."
        if (kind == null || kind.trim().isEmpty()) {
            throw new NullPointerException(ANIMAL_KIND_NULL_OR_EMPTY);
        }
        this.kind = kind;
        this.kg = kg;
        //If the price is below or equal to 0, throw an IllegalArgumentException with a message:
        // "Animal price cannot be below or equal to 0."
        if (price <= 0) {
            throw new IllegalArgumentException(ANIMAL_PRICE_BELOW_OR_EQUAL_ZERO);
        }
        this.price = price;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getKg() {
        return this.kg;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void eat() {
        this.kg += 0.1;
    }
}
