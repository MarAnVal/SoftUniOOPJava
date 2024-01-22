package main.java.Exam_15_August_2021.Restaurant.entities.tables.interfaces;

import main.java.Exam_15_August_2021.Restaurant.entities.drinks.interfaces.Beverages;
import main.java.Exam_15_August_2021.Restaurant.entities.healthyFoods.interfaces.HealthyFood;

public interface Table {
    int getTableNumber();

    int getSize();

    int numberOfPeople();

    double pricePerPerson();

    boolean isReservedTable();

    double allPeople();

    void reserve(int numberOfPeople);

    void orderHealthy(HealthyFood food);

    void orderBeverages(Beverages beverages);

    double bill();

    void clear();

    String tableInformation();
}
