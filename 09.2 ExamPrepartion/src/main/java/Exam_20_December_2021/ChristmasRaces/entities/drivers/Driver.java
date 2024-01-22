package main.java.Exam_20_December_2021.ChristmasRaces.entities.drivers;

import main.java.Exam_20_December_2021.ChristmasRaces.entities.cars.Car;

public interface Driver {
    String getName();

    Car getCar();

    int getNumberOfWins();

    void addCar(Car car);

    void winRace();

    boolean getCanParticipate();
}
