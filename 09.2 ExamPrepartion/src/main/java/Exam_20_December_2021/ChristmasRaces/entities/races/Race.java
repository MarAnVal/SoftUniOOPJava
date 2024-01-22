package main.java.Exam_20_December_2021.ChristmasRaces.entities.races;

import main.java.Exam_20_December_2021.ChristmasRaces.entities.drivers.Driver;

import java.util.Collection;

public interface Race {
    String getName();

    int getLaps();

    Collection<Driver> getDrivers();

    void addDriver(Driver driver);
}
