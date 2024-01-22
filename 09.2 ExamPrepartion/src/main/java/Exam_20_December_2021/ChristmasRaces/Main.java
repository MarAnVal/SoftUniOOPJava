package main.java.Exam_20_December_2021.ChristmasRaces;

import main.java.Exam_20_December_2021.ChristmasRaces.core.ControllerImpl;
import main.java.Exam_20_December_2021.ChristmasRaces.core.EngineImpl;
import main.java.Exam_20_December_2021.ChristmasRaces.core.interfaces.Controller;
import main.java.Exam_20_December_2021.ChristmasRaces.entities.cars.Car;
import main.java.Exam_20_December_2021.ChristmasRaces.entities.drivers.Driver;
import main.java.Exam_20_December_2021.ChristmasRaces.entities.races.Race;
import main.java.Exam_20_December_2021.ChristmasRaces.io.ConsoleReader;
import main.java.Exam_20_December_2021.ChristmasRaces.io.ConsoleWriter;
import main.java.Exam_20_December_2021.ChristmasRaces.repositories.CarRepository;
import main.java.Exam_20_December_2021.ChristmasRaces.repositories.DriverRepository;
import main.java.Exam_20_December_2021.ChristmasRaces.repositories.RaceRepository;
import main.java.Exam_20_December_2021.ChristmasRaces.repositories.interfaces.Repository;

public class Main {
    public static void main(String[] args) {
        Repository<Car> carRepository = new CarRepository<>();
        Repository<Race> raceRepository = new RaceRepository<>();
        Repository<Driver> driverRepository = new DriverRepository<>();

        Controller controller = new ControllerImpl(driverRepository, carRepository, raceRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
