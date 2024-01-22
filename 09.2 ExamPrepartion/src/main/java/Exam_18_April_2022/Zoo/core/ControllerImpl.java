package main.java.Exam_18_April_2022.Zoo.core;

import main.java.Exam_18_April_2022.Zoo.entities.animals.Animal;
import main.java.Exam_18_April_2022.Zoo.entities.animals.AquaticAnimal;
import main.java.Exam_18_April_2022.Zoo.entities.animals.TerrestrialAnimal;
import main.java.Exam_18_April_2022.Zoo.entities.areas.Area;
import main.java.Exam_18_April_2022.Zoo.entities.areas.LandArea;
import main.java.Exam_18_April_2022.Zoo.entities.areas.WaterArea;
import main.java.Exam_18_April_2022.Zoo.entities.foods.Food;
import main.java.Exam_18_April_2022.Zoo.entities.foods.Meat;
import main.java.Exam_18_April_2022.Zoo.entities.foods.Vegetable;
import main.java.Exam_18_April_2022.Zoo.repositories.FoodRepository;
import main.java.Exam_18_April_2022.Zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static main.java.Exam_18_April_2022.Zoo.common.ConstantMessages.*;
import static main.java.Exam_18_April_2022.Zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    //foodRepository - FoodRepository
    private FoodRepository foodRepository;
    //areas - a Collection of Area
    private List<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        //Adds an Area in the collection. Valid types are: "WaterArea" and "LandArea".
        Area area = null;
        switch (areaType) {
            case "WaterArea":
                area = new WaterArea(areaName);
                break;
            case "LandArea":
                area = new LandArea(areaName);
                break;
            default:
                //If the Area type is invalid, you have to throw a NullPointerException with the following message:
                //"Invalid area type."
                throw new NullPointerException(INVALID_AREA_TYPE);
        }
        areas.add(area);
        //If the Area is added successfully, the method should return the following String:
        //"Successfully added {areaType}."
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        //Creates a food of the given type and adds it to the FoodRepository.
        // Valid types are: " Vegetable" and "Meat".
        Food food = null;
        switch (foodType) {
            case "Vegetable":
                food = new Vegetable();
                break;
            case "Meat":
                food = new Meat();
                break;
            default:
                // If the food type is invalid,  throw an IllegalArgumentException with a message:
                //"Invalid food type."
                throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);
        //The method should return the following string if the operation is successful:
        //"Successfully added {foodType}."
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        //Adds the desired Food to the Area with the given name.
        Area givenArea = areas.stream().filter(e -> e.getName().equals(areaName)).findFirst().orElse(null);
        Food givenFood = foodRepository.findByType(foodType);
        if (givenFood == null) {
            //If there is no such food, you have to throw an IllegalArgumentException with the following message:
            //"There isn't a food of type {foodType}."
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }
        // You have to remove the Food from the FoodRepository if the insert is successful.
        givenArea.addFood(givenFood);
        foodRepository.remove(givenFood);
        //If no exceptions are thrown return the String:
        //"Successfully added {foodType} to {areaName}."
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        //Adds the desired Animal to the Area with the given name.
        // Valid Animal types are "AquaticAnimal", and "TerrestrialAnimal".
        Area givenArea = areas.stream().filter(e -> e.getName().equals(areaName)).findFirst().orElse(null);
        Animal animal = null;
        switch (animalType) {
            case "AquaticAnimal":
                if (givenArea.getClass().getSimpleName().equals("WaterArea")) {
                    animal = new AquaticAnimal(animalName, kind, price);
                }
                break;
            case "TerrestrialAnimal":
                if (givenArea.getClass().getSimpleName().equals("LandArea")) {
                    animal = new TerrestrialAnimal(animalName, kind, price);
                }
                break;
            default:
                //If the Animal type is invalid, you have to throw an IllegalArgumentException with the following message:
                //"Invalid animal type." - if the Animal type is invalid.
                throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }
        //If no errors are thrown, return one of the following strings:
        //"The external living environment is not suitable." - if the Animal cannot live in the Area
        if (animal == null) {
            return AREA_NOT_SUITABLE;
        }
        //"Not enough capacity." - if there is not enough capacity to add the Animal in the Area.
        int sizeBeforeAdd = givenArea.getAnimals().size();
        givenArea.addAnimal(animal);
        if (givenArea.getAnimals().size() == sizeBeforeAdd){
            return NOT_ENOUGH_CAPACITY;
        }
        //"Successfully added {animalType} to {areaName}." - if the Animal is added successfully in the Area
        return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    @Override
    public String feedAnimal(String areaName) {
        //Feeds all Animal in the Area with the given name.
        Area area = areas.stream().filter(e -> e.getName().equals(areaName)).findFirst().orElse(null);
        area.feed();
        //Returns a string with information about how many animals were successfully fed, in the following format:
        //"Animals fed: {fedCount}"
        return String.format(ANIMALS_FED, area.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = areas.stream().filter(e -> e.getName().equals(areaName)).findFirst().orElse(null);
        Collection<Animal> animals = area.getAnimals();
        double allKg = 0;
        for (Animal animal : animals) {
            allKg += animal.getKg();
        }
        //Calculates the value of the Area with the given name.
        // It is calculated by the sum of all Animal’s kilograms in the Area.
        //Return a string in the following format:
        //"The kilograms of Area {areaName} is {value}."
        //The value should be formatted to the 2nd decimal place!
        return String.format(KILOGRAMS_AREA, areaName, allKg);
    }

    @Override
    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < areas.size(); i++) {
            if (i < areas.size() - 1){
                text.append(areas.get(i).getInfo());
                text.append(System.lineSeparator());
            } else {
                text.append(areas.get(i).getInfo());
            }
        }
        //Returns information about each area. You can use the overridden .getInfo Area method.
        //"{areaName} ({areaType}):
        //Animals: {animalName1} {animalName2} {animalName3} (…) / Animals: none
        //Foods: {foodCount}
        //Calories: {areaCalories}
        //{areaName} ({areaType}):
        //Animals: {animalName1} {animalName2} {animalName3} (…) / Animals: none
        //Foods: {foodCount}
        //Calories: {areaCalories}
        // (…)"
        //Note: Use System.lineSeparator() for a new line.
        return text.toString();
    }
}
