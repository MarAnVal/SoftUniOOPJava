package main.java.Exam_15_August_2021.Restaurant.repositories;

import main.java.Exam_15_August_2021.Restaurant.entities.drinks.interfaces.Beverages;
import main.java.Exam_15_August_2021.Restaurant.repositories.interfaces.BeverageRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    private Collection<Beverages> beverages;

    public BeverageRepositoryImpl() {
        this.beverages = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        for (Beverages beverage : beverages) {
            if (beverage.getName().equals(drinkName) && beverage.getBrand().equals(drinkBrand)) {
                return beverage;
            }
        }
        return null;
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(this.beverages);
    }

    @Override
    public void add(Beverages beverage) {
        this.beverages.add(beverage);
    }
}
