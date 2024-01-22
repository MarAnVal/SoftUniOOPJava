package main.java.Exam_20_December_2021.ChristmasRaces.entities.cars;

public interface Car {
    String getModel();

    int getHorsePower();

    double getCubicCentimeters();

    double calculateRacePoints(int laps);
}
