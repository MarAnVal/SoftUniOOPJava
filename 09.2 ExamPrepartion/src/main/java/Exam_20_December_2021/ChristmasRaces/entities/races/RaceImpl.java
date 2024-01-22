package main.java.Exam_20_December_2021.ChristmasRaces.entities.races;

import main.java.Exam_20_December_2021.ChristmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static main.java.Exam_20_December_2021.ChristmasRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race{
    //name - String
    private String name;
    //laps - int
    private int laps;
    //drivers - A Collection of Drivers
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        //If the name is null, empty, or less than 5 symbols throw an
        // IllegalArgumentException with the message "Name {name} cannot be less than 5 symbols.".
        if (name == null || name.trim().isEmpty() || name.length()<5){
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        this.name = name;
        //Throws IllegalArgumentException with message "Laps cannot be less than 1.", if the laps are less than 1.
        if (laps < 1){
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS, 1));
        }
        this.laps = laps;
        this.drivers = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return Collections.unmodifiableCollection(this.drivers);
    }

    @Override
    public void addDriver(Driver driver) {
        //This method adds a Driver to the Race if the Driver is valid.
        // If the Driver is not valid, throw an Exception with the appropriate message.
        //Exceptions are:
        //If a Driver is null throw an IllegalArgumentException with a message "Driver cannot be null.".
        if (driver == null){
            throw new IllegalArgumentException(DRIVER_INVALID);
        }
        //If a Driver cannot participate in the Race (the Driver doesn't own a Car)
        // throw an IllegalArgumentException with a message "Driver {driver name} could not participate in race.".
        if (driver.getCar() == null){
            throw new IllegalArgumentException(String.format(DRIVER_NOT_PARTICIPATE,driver.getName()));
        }
        //If the Driver already exists in the Race throw an IllegalArgumentException with a message:
        //"Driver {driver name} is already added in {race name} race.".
        if(drivers.contains(driver)){
            throw new IllegalArgumentException(String.format(DRIVER_ALREADY_ADDED, driver.getName(), this.getName()));
        }
        this.drivers.add(driver);
    }
}
