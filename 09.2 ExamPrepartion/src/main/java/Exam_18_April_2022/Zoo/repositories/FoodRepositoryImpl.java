package main.java.Exam_18_April_2022.Zoo.repositories;

import main.java.Exam_18_April_2022.Zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;

public class FoodRepositoryImpl implements FoodRepository{
    //foods - Collection<Food>
    private Collection<Food> foods;

    public FoodRepositoryImpl() {
        this.foods = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        this.foods.add(food);
    }

    @Override
    public boolean remove(Food food) {
        //Removes food from the collection. Returns true if the deletion was successful, otherwise - false.
        return this.foods.remove(food);
    }

    @Override
    public Food findByType(String type) {
        //Returns the first food of the given type, if there is. Otherwise, returns null.
        for (Food food : foods) {
            if(food.getClass().getSimpleName().equals(type)){
                return food;
            }
        }
        return null;
    }

}
