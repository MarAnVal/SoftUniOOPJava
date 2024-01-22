package main.java.Exam_18_April_2022.Zoo.core;

import main.java.Exam_18_April_2022.Zoo.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals("Exit")) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }
    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddArea:
                result = addArea(data);
                break;
            case BuyFood:
                result = buyFood(data);
                break;
            case FoodForArea:
                result = foodForArea(data);
                break;
            case AddAnimal:
                result = addAnimal(data);
                break;
            case FeedAnimal:
                result = feedAnimal(data);
                break;
            case CalculateKg:
                result = calculateKg(data);
                break;
            case GetStatistics:
                result = getStatistics();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }
    private String addArea(String[] data) {
        //AddArea {areaType} {areaName}
        String areaType = data[0];
        String areaName = data[1];
        return controller.addArea(areaType, areaName);
    }

    private String buyFood(String[] data) {
        //BuyFood {foodType}
        String foodType = data[0];
        return controller.buyFood(foodType);
    }

    private String foodForArea(String[] data) {
        //FoodForArea {areaName} {foodType}
        String areaName = data[0];
        String foodType = data[1];
        return controller.foodForArea(areaName, foodType);
    }

    private String addAnimal(String[] data) {
        //AddAnimal {areaName} {animalType} {animalName} {animalKind} {price}
        String areaName = data[0];
        String animalType = data[1];
        String animalName = data[2];
        String animalKind = data[3];
        double price = Double.parseDouble(data[4]);
        return controller.addAnimal(areaName, animalType, animalName, animalKind, price);
    }

    private String feedAnimal(String[] data) {
        //FeedAnimal {areaName}
        String areaName = data[0];
        return controller.feedAnimal(areaName);
    }

    private String calculateKg(String[] data) {
        //CalculateKg {areaName}
        String areaName = data[0];
        return controller.calculateKg(areaName);
    }

    private String getStatistics() {
        //GetStatistics
        return controller.getStatistics();
    }
}