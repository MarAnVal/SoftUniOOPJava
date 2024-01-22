package main.java.Exam_11_December_2021.CatHouse.core;

import main.java.Exam_11_December_2021.CatHouse.entities.cat.Cat;
import main.java.Exam_11_December_2021.CatHouse.entities.cat.LonghairCat;
import main.java.Exam_11_December_2021.CatHouse.entities.cat.ShorthairCat;
import main.java.Exam_11_December_2021.CatHouse.entities.houses.House;
import main.java.Exam_11_December_2021.CatHouse.entities.houses.LongHouse;
import main.java.Exam_11_December_2021.CatHouse.entities.houses.ShortHouse;
import main.java.Exam_11_December_2021.CatHouse.entities.toys.Ball;
import main.java.Exam_11_December_2021.CatHouse.entities.toys.Mouse;
import main.java.Exam_11_December_2021.CatHouse.entities.toys.Toy;
import main.java.Exam_11_December_2021.CatHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static main.java.Exam_11_December_2021.CatHouse.common.ConstantMessages.*;
import static main.java.Exam_11_December_2021.CatHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    //toys - ToyRepository
    private ToyRepository toyRepository;
    //houses - Collection<House>
    private Collection<House> houses;

    public ControllerImpl() {
        this.toyRepository = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        //Creates and adds a House to the houses’ collection. Valid types are: "ShortHouse" and "LongHouse".
        House house = null;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                //If the House type is invalid, you have to throw a NullPointerException with the following message:
                //"Invalid house type."
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        houses.add(house);
        //If the House is added successfully, the method should return the following String:
        //"{houseType} is successfully added."
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        //Creates a toy of the given type and adds it to the ToyRepository.
        Toy toy = null;
        // Valid types are: "Ball" and "Mouse". If the toy type is invalid,
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                // throw an IllegalArgumentException with a message:
                //"Invalid toy type."
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        toyRepository.buyToy(toy);
        //The method should return the following string if the operation is successful:
        //"{toyType} is successfully added."
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        //Adds (buys) the desired Toy to the House with the given name.
        Toy toy = toyRepository.findFirst(toyType);
        if (toy == null) {
            //If there is no such toy, you have to throw an IllegalArgumentException with the following message:
            //"Toy of type {toyType} is missing."
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }
        // You have to remove the Toy from the ToyRepository if the insert is successful.
        House house = houses.stream().filter(e -> e.getName().equals(houseName)).findFirst().orElse(null);
        house.buyToy(toy);
        toyRepository.removeToy(toy);
        //If no exceptions are thrown, return the String:
        //"Successfully added {toyType} to {houseName}."
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        //Creates and adds the desired Cat to the House with the given name.
        Cat cat = null;
        // Valid Cat types are: "ShorthairCat", "LonghairCat".
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                //If the Cat type is invalid, you have to throw an IllegalArgumentException with the following message:
                //"Invalid cat type."
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        //Note: The method must first check whether the cat type is valid.
        House house = houses.stream().filter(e -> e.getName().equals(houseName))
                .findFirst().orElse(null);
        String houseType = house.getClass().getSimpleName();
        String type = cat.getClass().getSimpleName();
        boolean suitable = (houseType.startsWith("Short") && type.startsWith("Short"))
                || (houseType.startsWith("Long") && type.startsWith("Long"));
        if (!suitable) {
            //"Unsuitable house." - if the given Cat cannot live in the House.
            throw new IllegalArgumentException(UNSUITABLE_HOUSE);
        }
        house.addCat(cat);
        //If no errors are thrown, return one of the following strings:
        //"Successfully added {catType} to {houseName}." - if the Cat is added successfully in the House.
        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, type, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        //Feeds all Cat in the House with the given name.
        House house = houses.stream().filter(e -> e.getName().equals(houseName))
                .findFirst().orElse(null);
        house.feeding();
        //Returns a string with information about how many cats were successfully fed, in the following format:
        //"Feeding a cat: {fedCount}"
        return String.format(FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        //Calculates the value of the House with the given name.
        // It is calculated by the sum of all Cat’s and Toy’s prices in the House.
        double houseValue = 0;
        House house = houses.stream().filter(e -> e.getName().equals(houseName)).findFirst().orElse(null);
        Collection<Cat> cats = house.getCats();
        for (Cat cat : cats) {
            houseValue += cat.getPrice();
        }
        Collection<Toy> toys = house.getToys();
        for (Toy toy : toys) {
            houseValue += toy.getPrice();
        }
        //Return a string in the following format:
        //"The value of House {houseName} is {value}."
        //The value should be formatted to the 2nd decimal place!
        return String.format(VALUE_HOUSE, houseName, houseValue);
    }

    @Override
    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        List<House> housesForPrint = (List<House>) this.houses;
        for (int i = 0; i < housesForPrint.size(); i++) {
            if (i < housesForPrint.size() - 1){
                text.append(housesForPrint.get(i).getStatistics());
                text.append(System.lineSeparator());
            } else {
                text.append(housesForPrint.get(i).getStatistics());
            }
        }
        //Returns information about each house. You can use House's getStatistics
        // method to implement the current functionality.
        //"{houseName} {houseType}:
        //Cats: {catName1} {catName2} {catName3} ... / Cats: none
        //Toys: {toysCount} Softness: {sumSoftness}"
        //"{houseName} {houseType}:
        //Cats: {catName1} {catName2} {catName3} ... / Cats: none
        //Toys: {toysCount} Softness: {sumSoftness}"
        //..."
        return text.toString();
    }
}
