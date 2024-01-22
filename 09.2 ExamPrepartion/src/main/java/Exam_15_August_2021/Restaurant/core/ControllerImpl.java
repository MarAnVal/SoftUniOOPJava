package main.java.Exam_15_August_2021.Restaurant.core;

import main.java.Exam_15_August_2021.Restaurant.common.enums.BeveragesType;
import main.java.Exam_15_August_2021.Restaurant.common.enums.HealthyFoodType;
import main.java.Exam_15_August_2021.Restaurant.common.enums.TableType;
import main.java.Exam_15_August_2021.Restaurant.core.interfaces.Controller;
import main.java.Exam_15_August_2021.Restaurant.entities.drinks.Fresh;
import main.java.Exam_15_August_2021.Restaurant.entities.drinks.Smoothie;
import main.java.Exam_15_August_2021.Restaurant.entities.drinks.interfaces.Beverages;
import main.java.Exam_15_August_2021.Restaurant.entities.healthyFoods.Food;
import main.java.Exam_15_August_2021.Restaurant.entities.healthyFoods.Salad;
import main.java.Exam_15_August_2021.Restaurant.entities.healthyFoods.VeganBiscuits;
import main.java.Exam_15_August_2021.Restaurant.entities.healthyFoods.interfaces.HealthyFood;
import main.java.Exam_15_August_2021.Restaurant.entities.tables.InGarden;
import main.java.Exam_15_August_2021.Restaurant.entities.tables.Indoors;
import main.java.Exam_15_August_2021.Restaurant.entities.tables.interfaces.Table;
import main.java.Exam_15_August_2021.Restaurant.repositories.interfaces.BeverageRepository;
import main.java.Exam_15_August_2021.Restaurant.repositories.interfaces.HealthFoodRepository;
import main.java.Exam_15_August_2021.Restaurant.repositories.interfaces.TableRepository;

import java.util.Collection;

import static main.java.Exam_15_August_2021.Restaurant.common.ExceptionMessages.*;
import static main.java.Exam_15_August_2021.Restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double totalMoneyForTheRestaurant;


    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository,TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository =beverageRepository;
        this.tableRepository = tableRepository;
        this.totalMoneyForTheRestaurant = 0;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        //addHealthyFood {type} {price} {name}
        //Important! Firstly create the corresponding object,
        // if possible, and then check if it exists in the records.
        HealthyFoodType healthyFoodType = HealthyFoodType.valueOf(type);
        Food food = null;
        switch (healthyFoodType) {
            case Salad:
                food = new Salad(name, price);
                break;
            case VeganBiscuits:
                food = new VeganBiscuits(name, price);
        }

        HealthyFood foodExist = healthFoodRepository.foodByName(food.getName());
        if (foodExist != null) {
            //If a healthy food with the given name already exists in the food repository,
            // throw an IllegalArgumentException with the message "{name} is already in the healthy menu!"
            throw new IllegalArgumentException(String.format(FOOD_EXIST, food.getName()));
        }
        healthFoodRepository.add(food);
        //Creates food with the correct type. If the food is created successfully add it to the food
        // repository and returns: "Added {name} to the healthy menu!"
        return String.format(FOOD_ADDED, food.getName());
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        //Important! Firstly create the corresponding object,
        // if possible, and then check if it exists in the records.
        BeveragesType beveragesType = BeveragesType.valueOf(type);
        Beverages beverage = null;
        switch (beveragesType){
            case Fresh:
                beverage = new Fresh(name, counter, brand);
                break;
            case Smoothie:
                beverage = new Smoothie(name,counter,brand);
                break;
        }
        Beverages beverageExist = beverageRepository.beverageByName(beverage.getName(),beverage.getBrand());
        //FIXME?
        if (beverageExist != null) {
            //If a beverage with the given name already exists in the beverage repository,
            // throw an IllegalArgumentException with the message "{name} is already in the beverage menu!"
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, beverage.getName()));
        }
        beverageRepository.add(beverage);
        //Creates a beverage with the correct type. If the beverage is created successful, returns:
        //"Added {type} - {brand} to the beverage menu!"
        return String.format(BEVERAGE_ADDED, beverage.getClass().getSimpleName(), beverage.getBrand());
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        //Important! Firstly create the corresponding object,
        // if possible, and then check if it exists in the records.
        TableType tableType = TableType.valueOf(type);
        Table table = null;
        switch (tableType){
            case InGarden:
                table = new InGarden(tableNumber, capacity);
                break;
            case Indoors:
                table = new Indoors(tableNumber,capacity);
        }
        Table tableExist = tableRepository.byNumber(table.getTableNumber());
        if(tableExist !=null) {
            //If a table with the given number already exists in the table repository, throw an
            // IllegalArgumentException with the message "Table {number} is already added to the healthy restaurant!"
            throw new IllegalArgumentException(String.format(TABLE_IS_ALREADY_ADDED, table.getTableNumber()));
        }
        tableRepository.add(table);
        //Creates a table with the correct type and returns:
        //"Added table number {number} in the healthy restaurant!"
        return String.format(TABLE_ADDED, table.getTableNumber());
    }

    @Override
    public String reserve(int numberOfPeople) {
        //Finds a table which is not reserved, and its size is enough for the number of people provided.
        Collection<Table> tables = tableRepository.getAllEntities();
        Table table = null;
        for (Table currentTable : tables) {
            int size = currentTable.getSize();
            if(currentTable.getSize() >= numberOfPeople&&!currentTable.isReservedTable()){
                table = currentTable;
                break;
            }
        }

        if (table == null) {
            // If there is no such table returns:
            //"There is no such table for {numberOfPeople} people."
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        table.reserve(numberOfPeople);
        //In the other case reserves the table and returns:
        //"Table {number} has been reserved for {numberOfPeople} people."
        return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        //Finds the table with that number and the food with that name on the menu.
        Table table = tableRepository.getAllEntities().stream().filter(e -> e.getTableNumber() == tableNumber)
                .findFirst().orElse(null);
        if(table == null) {
            // You first check if the table exists. If there are no such table returns:
            //"Could not find table {tableNumber}."
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        HealthyFood healthyFood = healthFoodRepository.foodByName(healthyFoodName);
        if(healthyFood == null) {
            //If there are no such food returns:
            //"No {healthyFoodName} in the healthy menu."
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        }
        table.orderHealthy(healthyFood);
        //In other cases orders the food for that table and returns:
        //"{healthyFoodName} ordered from table {tableNumber}."
        return String.format(FOOD_ORDER_SUCCESSFUL, healthyFood.getName(), table.getTableNumber());
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        //Finds the table with that number and the food with that name on the menu.
        Table table = tableRepository.getAllEntities().stream().filter(e -> e.getTableNumber() == tableNumber)
                .findFirst().orElse(null);
        if(table == null) {
            // You first check if the table exists. If there are no such table returns:
            //"Could not find table {tableNumber}."
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        Beverages beverage = beverageRepository.beverageByName(name, brand);
        if(beverage == null) {
            //If there isn’t such beverage, it returns:
            //"No {name} - {brand} in the beverage menu."
            return String.format(NON_EXISTENT_DRINK, name, brand);
        }
        table.orderBeverages(beverage);
        //In another case, it orders the beverage for that table and returns:
        //"{name} ordered from table {tableNumber}."
        return String.format(BEVERAGE_ORDER_SUCCESSFUL, beverage.getName(), table.getTableNumber());
    }

    @Override
    public String closedBill(int tableNumber) {
        //Finds the table with the same table number.
        Table table = tableRepository.getAllEntities().stream().filter(e -> e.getTableNumber() == tableNumber)
                .findFirst().orElse(null);
        Double bill = table.bill();
        table.clear();
        this.totalMoneyForTheRestaurant += bill;
        // Gets the bill for that table and clears it. Finally returns:
        //"Table: {tableNumber} with bill: {table bill formatted to the second digit}."
        return String.format(BILL, table.getTableNumber(), bill);
    }


    @Override
    public String totalMoney() {
        //Returns the money earned for the restaurant for all completed bills.
        //"Total money for the restaurant: {money formatted to the second digit}lv."
        return String.format(TOTAL_MONEY, this.totalMoneyForTheRestaurant);
    }
}
