package main.java.Exam_20_December_2021.ChristmasRaces.repositories;

import main.java.Exam_20_December_2021.ChristmasRaces.entities.cars.Car;
import main.java.Exam_20_December_2021.ChristmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CarRepository<T extends Car> implements Repository<T> {
    //models - a Collection of T (entity)
    private Collection<T> cars;

    public CarRepository() {
        this.cars = new ArrayList<>();
    }

    @Override
    public T getByName(String model) {
        for (Car car : this.cars) {
            if (car.getModel().equals(model)){
                return (T) car;
            }
        }
        return null;
    }

    @Override
    public Collection<T> getAll() {
        return Collections.unmodifiableCollection(this.cars);
    }

    @Override
    public void add(T model) {
        this.cars.add(model);
    }

    @Override
    public boolean remove(T model) {
        return this.cars.remove(model);
    }


}
