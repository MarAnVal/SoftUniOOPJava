package main.java.Exam_18_April_2022.Zoo.entities.areas;

import main.java.Exam_18_April_2022.Zoo.entities.animals.Animal;
import main.java.Exam_18_April_2022.Zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static main.java.Exam_18_April_2022.Zoo.common.ExceptionMessages.AREA_NAME_NULL_OR_EMPTY;
import static main.java.Exam_18_April_2022.Zoo.common.ExceptionMessages.NOT_ENOUGH_CAPACITY;


public abstract class BaseArea implements Area {
    //name - String
    private String name;
    //capacity -  int
    private int capacity;
    //foods - Collection<Food>
    private Collection<Food> foods;
    //animals - Collection<Animal>
    private Collection<Animal> animals;

    public BaseArea(String name, int capacity) {
        //If the name is null or whitespace, throw a NullPointerException with a message:
        //"Area name cannot be null or empty."
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return this.animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return this.foods;
    }

    @Override
    public int sumCalories() {
        int sum = 0;
        for (Food food : this.foods) {
            sum += food.getCalories();
        }
        return sum;
    }

    @Override
    public void addAnimal(Animal animal) {
        //Adds an Animal in the Area if there is the capacity for it.
        //If there is not enough capacity to add the Animal in the
        // Area throw an IllegalStateException with the following message:
        //"Not enough capacity."
        if(this.capacity == this.animals.size()){
            throw  new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public void feed() {
        for (Animal animal : this.animals) {
            animal.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder text = new StringBuilder();
        //Returns a String with information about the Area in the format below.
        // If the Area doesn't have an animal, print "none" instead.
        //"{areaName} ({areaType}):
        text.append(String.format("%s (%s):", this.name, this.getClass().getSimpleName()));
        text.append(System.lineSeparator());
        List<String> animalsNames = new ArrayList<>();
        animals.forEach(e -> animalsNames.add(e.getName()));
        String animalsByNames = "none";
                if (!animalsNames.isEmpty()){
                    animalsByNames =  String.join(" ", animalsNames);
                }
        //Animals: {animalName1} {animalName2} {animalName3} (…) / Animals: none
        text.append(String.format("Animals: %s", animalsByNames));
        text.append(System.lineSeparator());
        //Foods: {foodsCount}
        text.append(String.format("Foods: %d", this.foods.size()));
        text.append(System.lineSeparator());
        int sumCalories = 0;
        for (Food food : this.foods) {
            sumCalories += food.getCalories();
        }
        //Calories: {sumCalories}"
        text.append(String.format("Calories: %d", sumCalories));
        //Note: Use System.lineSeparator() for a new line.
        return text.toString();
    }
}
