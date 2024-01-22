package main.java.Exam_20_December_2021.ChristmasRaces.repositories;

import main.java.Exam_20_December_2021.ChristmasRaces.entities.drivers.Driver;
import main.java.Exam_20_December_2021.ChristmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DriverRepository<T extends Driver> implements Repository<T> {
    private Collection<T> drivers;

    public DriverRepository() {
        this.drivers = new ArrayList<>();
    }

    @Override
    public T getByName(String name) {
        for (Driver driver : this.drivers) {
            if (driver.getName().equals(name)) {
                return (T) driver;
            }
        }
        return null;
    }

    @Override
    public Collection<T> getAll() {
        return Collections.unmodifiableCollection(this.drivers);
    }

    @Override
    public void add(T driver) {
        this.drivers.add(driver);
    }

    @Override
    public boolean remove(T driver) {
        return this.drivers.remove(driver);
    }
}
