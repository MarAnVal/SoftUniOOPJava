package main.java.Exam_11_December_2021.CatHouse.entities.houses;

import main.java.Exam_11_December_2021.CatHouse.entities.cat.Cat;
import main.java.Exam_11_December_2021.CatHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static main.java.Exam_11_December_2021.CatHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static main.java.Exam_11_December_2021.CatHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House{
    //name - String
    private String name;
    //capacity -  int
    private int capacity;
    //toys - Collection<Toy>
    private Collection<Toy> toys;
    //cats - Collection<Cat>
    private Collection<Cat> cats;

    //(String name, int capacity)
    public BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public void setName(String name) {
        //If the name is null or whitespace, throw a NullPointerException with a message:
        //"House name cannot be null or empty."
        if(name==null||name.trim().isEmpty()){
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }
    @Override
    public int sumSoftness() {
        int sumSoftness = 0;
        for (Toy toy : toys) {
            sumSoftness += toy.getSoftness();
        }
        return sumSoftness;
    }

    @Override
    public void addCat(Cat cat) {
        //If there is not enough capacity to add the Cat in the House,
        // throw an IllegalStateException with the following message:
        //"Not enough capacity for this cat."
        if(capacity==this.cats.size()){
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        //Adds a Cat in the House if there is a capacity for it.
        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        //Removes a Cat from the House.
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        //Buy (adds) a Toy in the House.
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        //The feeding() method feeds all cats in the House.
        this.cats.forEach(e -> e.eating());
    }

    @Override
    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        //Returns a String with information about the House in the format below.
        //"{houseName} {houseType}:
        text.append(String.format("%s %s:", this.name, this.getClass().getSimpleName()));
        //If the House doesn't have a cat, print "none" instead.
        String catsInHouse = "none";
        if(!cats.isEmpty()){
            List<String> catsNames = new ArrayList<>();
            for (Cat cat : cats) {
                String catsName = cat.getName();
                catsNames.add(catsName);
            }
            catsInHouse = String.join(" ", catsNames);
        }
        //Cats: {catName1} {catName2} {catName3} ... / Cats: none
        text.append(System.lineSeparator());
        text.append(String.format("Cats: %s", catsInHouse));
        //Toys: {toysCount} Softness: {sumSoftness}"
        text.append(System.lineSeparator());
        text.append(String.format("Toys: %d Softness: %d", this.toys.size(), this.sumSoftness()));
        return text.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
