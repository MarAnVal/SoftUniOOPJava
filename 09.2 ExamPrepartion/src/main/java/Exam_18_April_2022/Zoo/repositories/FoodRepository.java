package main.java.Exam_18_April_2022.Zoo.repositories;

import main.java.Exam_18_April_2022.Zoo.entities.foods.Food;

public interface FoodRepository {
    void add(Food food);

    boolean remove(Food food);

    Food findByType(String type);
}
