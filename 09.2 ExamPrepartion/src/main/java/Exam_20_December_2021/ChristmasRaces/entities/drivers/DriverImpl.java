package main.java.Exam_20_December_2021.ChristmasRaces.entities.drivers;

import main.java.Exam_20_December_2021.ChristmasRaces.entities.cars.Car;

import static main.java.Exam_20_December_2021.ChristmasRaces.common.ExceptionMessages.CAR_INVALID;
import static main.java.Exam_20_December_2021.ChristmasRaces.common.ExceptionMessages.INVALID_NAME;

public class DriverImpl implements Driver {
    //name - String
    private String name;
    //car - Car
    private Car car;
    //numberOfWins - int
    private int numberOfWins;
    //canParticipate - boolean
    private boolean canParticipate;

    public DriverImpl(String name) {
        //If the name is null, empty, or less than 5 symbols throw an IllegalArgumentException
        // with the message "Name {name} cannot be less than 5 symbols.".
        if (name == null || name.trim().isEmpty() || name.length() < 5){
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        this.name = name;
        this.car = null;
        this.numberOfWins = 0;
        //The default behavior is false.
        //The Driver can participate in a race, ONLY if he has a Car (Car is not null).
        this.canParticipate = false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        //This method adds a Car to the Driver. If the car is null,
        // throw IllegalArgumentException with the message "Car cannot be null.".
        //If the given Car is not null, set the current Car as the given one and after that
        // Driver can participate in a race.
        if (car == null) {
            throw new IllegalArgumentException(CAR_INVALID);
        }
        this.car = car;
        this.canParticipate = true;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }

}
