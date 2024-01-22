package main.java.Exam_20_December_2021.ChristmasRaces.core;

import main.java.Exam_20_December_2021.ChristmasRaces.core.interfaces.Controller;
import main.java.Exam_20_December_2021.ChristmasRaces.entities.cars.Car;
import main.java.Exam_20_December_2021.ChristmasRaces.entities.cars.MuscleCar;
import main.java.Exam_20_December_2021.ChristmasRaces.entities.cars.SportsCar;
import main.java.Exam_20_December_2021.ChristmasRaces.entities.drivers.Driver;
import main.java.Exam_20_December_2021.ChristmasRaces.entities.drivers.DriverImpl;
import main.java.Exam_20_December_2021.ChristmasRaces.entities.races.Race;
import main.java.Exam_20_December_2021.ChristmasRaces.entities.races.RaceImpl;
import main.java.Exam_20_December_2021.ChristmasRaces.repositories.interfaces.Repository;

import java.util.Collection;

import static main.java.Exam_20_December_2021.ChristmasRaces.common.ExceptionMessages.*;
import static main.java.Exam_20_December_2021.ChristmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driverName) {
        //If a driver with the given name already exists in the driver repository,
        // throw an IllegalArgumentException with a message:
        //"Driver {name} is already created."
        if (driverRepository.getByName(driverName) != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driverName));
        }
        //Creates a Driver with the given name and adds it to the appropriate repository.
        Driver driver = new DriverImpl(driverName);
        driverRepository.add(driver);
        //The method should return the following message:
        //"Driver {name} is created."
        return String.format(DRIVER_CREATED, driverName);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        //If the Car already exists in the appropriate repository throw an IllegalArgumentException
        // with the following message:
        //"Car {model} is already created."
        if (carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }
        // There are two types of Car: "MuscleCar" and "SportsCar".
        //The command will be in the following format: "CreateCar {"Muscle"/"Sports"} {model} {name}".
        Car car = null;
        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                break;
        }
        //Create a Car with the provided model and horsepower and add it to the repository.
        carRepository.add(car);
        //If the Car is successfully created, the method should return the following message:
        //"{"MuscleCar"/ "SportsCar"} {model} is created."
        return String.format(CAR_CREATED, type, model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null) {
            //If the Driver does not exist in the DriverRepository, throw IllegalArgumentException with message
            //"Driver {name} could not be found."
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        Car car = carRepository.getByName(carModel);
        if (car == null) {
            //If the Car does not exist in the CarRepository, throw IllegalArgumentException with message
            //"Car {name} could not be found."
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }
        //Gives the Car with a given name to the Driver with a given name (if exists).
        driver.addCar(car);
        //If everything is successful you should add the Car to the Driver and return the following message:
        //"Driver {driver name} received car {car name}."
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            //If the Race does not exist in the RaceRepository, throw an IllegalArgumentException with a message:
            //"Race {name} could not be found."
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null) {
            //If the Driver does not exist in the DriverRepository, throw an IllegalArgumentException with a message:
            //"Driver {name} could not be found."
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        //Adds a Driver to the Race.
        race.addDriver(driver);
        //If everything is successful, you should add the Driver to the Race and return the following message:
        //"Driver {driver name} added in {race name} race."
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            //If the Race does not exist in RaceRepository, throw an IllegalArgumentException with a message:
            //"Race {name} could not be found."
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        if (race.getDrivers().size() < 3) {
            //If the participants in the race are less than 3, throw an IllegalArgumentException with a message:
            //"Race {race name} cannot start with less than 3 participants."
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }
        //you should sort all Drivers in descending order by the result of
        // CalculateRacePoints method in the Car object.
        Collection<Driver> drivers = race.getDrivers();
        Driver first = null;
        Driver second = null;
        Driver third = null;
        int laps = race.getLaps();
        for (Driver driver : drivers) {
            if (first == null) {
                first = driver;
            } else if (second == null) {
                if (first.getCar().calculateRacePoints(laps) < driver.getCar().calculateRacePoints(laps)) {
                    second = first;
                    first = driver;
                } else {
                    second = driver;
                }
            } else if (third == null) {
                if (first.getCar().calculateRacePoints(laps) < driver.getCar().calculateRacePoints(laps)) {
                    second = first;
                    third = second;
                    first = driver;
                } else if (second.getCar().calculateRacePoints(laps) < driver.getCar().calculateRacePoints(laps)) {
                    third = second;
                    second = driver;
                } else {
                    third = driver;
                }

            } else {
                if (first.getCar().calculateRacePoints(laps) < driver.getCar().calculateRacePoints(laps)) {
                    second = first;
                    third = second;
                    first = driver;
                } else if (second.getCar().calculateRacePoints(laps) < driver.getCar().calculateRacePoints(laps)) {
                    third = second;
                    second = driver;
                } else if (third.getCar().calculateRacePoints(laps) < driver.getCar().calculateRacePoints(laps)) {
                    third = driver;
                }
            }
        }
        // In the end, if everything is valid remove this Race from the race repository.
        raceRepository.remove(race);
        first.winRace();
        StringBuilder text = new StringBuilder();
        //If everything is successful, you should return the following message:
        //"Driver {first driver name} wins {race name} race."
        text.append(String.format(DRIVER_FIRST_POSITION, first.getName(), race.getName()));
        text.append(System.lineSeparator());
        //"Driver {second driver name} is second in {race name} race."
        text.append(String.format(DRIVER_SECOND_POSITION, second.getName(), race.getName()));
        text.append(System.lineSeparator());
        //"Driver {third driver name} is third in {race name} race."
        text.append(String.format(DRIVER_THIRD_POSITION, third.getName(), race.getName()));
        text.append(System.lineSeparator());
        return text.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        if (raceRepository.getByName(name) != null) {
            //If the Race with the given name already exists, throw an IllegalArgumentException with a message:
            //"Race {name} is already created."
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        //Creates a Race with the given name and laps and adds it to the RaceRepository.
        Race race = new RaceImpl(name, laps);
        raceRepository.add(race);
        //If everything is successful you should return the following message:
        //"Race {name} is created."
        return String.format(RACE_CREATED, name);
    }
}
