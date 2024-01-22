package main.java.Exam_15_August_2021.Restaurant;

import main.java.Exam_15_August_2021.Restaurant.core.ControllerImpl;
import main.java.Exam_15_August_2021.Restaurant.core.EngineImpl;
import main.java.Exam_15_August_2021.Restaurant.core.interfaces.Controller;
import main.java.Exam_15_August_2021.Restaurant.entities.drinks.interfaces.Beverages;
import main.java.Exam_15_August_2021.Restaurant.entities.healthyFoods.interfaces.HealthyFood;
import main.java.Exam_15_August_2021.Restaurant.entities.tables.interfaces.Table;
import main.java.Exam_15_August_2021.Restaurant.io.ConsoleReader;
import main.java.Exam_15_August_2021.Restaurant.io.ConsoleWriter;
import main.java.Exam_15_August_2021.Restaurant.repositories.BeverageRepositoryImpl;
import main.java.Exam_15_August_2021.Restaurant.repositories.HealthFoodRepositoryImpl;
import main.java.Exam_15_August_2021.Restaurant.repositories.TableRepositoryImpl;
import main.java.Exam_15_August_2021.Restaurant.repositories.interfaces.BeverageRepository;
import main.java.Exam_15_August_2021.Restaurant.repositories.interfaces.HealthFoodRepository;
import main.java.Exam_15_August_2021.Restaurant.repositories.interfaces.TableRepository;

public class Main {

    public static void main(String[] args) {
        HealthFoodRepository<HealthyFood> healthFoodRepository = new HealthFoodRepositoryImpl();
        BeverageRepository<Beverages> beverageRepository = new BeverageRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();

        Controller controller = new ControllerImpl(healthFoodRepository, beverageRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
