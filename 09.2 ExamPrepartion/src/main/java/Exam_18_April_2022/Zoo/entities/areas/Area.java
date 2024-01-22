package main.java.Exam_18_April_2022.Zoo.entities.areas;

import main.java.Exam_18_April_2022.Zoo.entities.animals.Animal;
import main.java.Exam_18_April_2022.Zoo.entities.foods.Food;

import java.util.Collection;

public interface Area {
    String getName();

    Collection<Animal> getAnimals();

    Collection<Food> getFoods();

    int sumCalories();

    void addAnimal(Animal animal);

    void removeAnimal(Animal animal);

    void addFood(Food food);

    void feed();

    String getInfo();
}
