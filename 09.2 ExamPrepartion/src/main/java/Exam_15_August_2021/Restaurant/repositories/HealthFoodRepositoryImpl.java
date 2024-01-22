package main.java.Exam_15_August_2021.Restaurant.repositories;

import main.java.Exam_15_August_2021.Restaurant.entities.healthyFoods.interfaces.HealthyFood;
import main.java.Exam_15_August_2021.Restaurant.repositories.interfaces.HealthFoodRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {
    private Collection<HealthyFood> foods;

    public HealthFoodRepositoryImpl() {
        this.foods = new ArrayList<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        for (HealthyFood food : this.foods) {
            if(food.getName().equals(name)){
                return food;
            }
        }
        return null;
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return Collections.unmodifiableCollection(this.foods);
    }

    @Override
    public void add(HealthyFood food) {
        this.foods.add(food);
    }
}
