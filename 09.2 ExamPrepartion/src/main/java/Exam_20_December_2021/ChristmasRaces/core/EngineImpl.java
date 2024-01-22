package main.java.Exam_20_December_2021.ChristmasRaces.core;


import main.java.Exam_20_December_2021.ChristmasRaces.common.Command;
import main.java.Exam_20_December_2021.ChristmasRaces.core.interfaces.Controller;
import main.java.Exam_20_December_2021.ChristmasRaces.core.interfaces.Engine;
import main.java.Exam_20_December_2021.ChristmasRaces.io.interfaces.InputReader;
import main.java.Exam_20_December_2021.ChristmasRaces.io.interfaces.OutputWriter;

import java.io.IOException;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private InputReader reader;
    private OutputWriter writer;
    private Controller controller;

    public EngineImpl(InputReader reader, OutputWriter writer, Controller controller) {
        this.reader = reader;
        this.writer = writer;
        this.controller = controller;
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.End.name())) {
                    break;
                }

            } catch (IOException | IllegalArgumentException | NullPointerException e) {
                result = e.getMessage();
            }

            this.writer.writeLine(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        String result = null;

        switch (command) {
            case AddDriverToRace:
                result = this.addDriver(data);
                break;
            case End:
                result = Command.End.name();
                break;
            case StartRace:
                result = this.startRace(data);
                break;
            case CreateDriver:
                result = this.createDriver(data);
                break;
            case AddCarToDriver:
                result = this.addCar(data);
                break;
            case CreateCar:
                result = this.createCar(data);
                break;
            case CreateRace:
                result = this.createRace(data);
                break;
        }
        return result;
    }

    private String createRace(String[] data) {
        // CreateRace {name} {laps}
        String name = data[0];
        int laps = Integer.parseInt(data[1]);
        return controller.createRace(name, laps);
    }

    private String addDriver(String[] data) {
        //AddDriverToRace {race name} {driver name}
        String raceName = data[0];
        String driverName = data[1];
        return controller.addDriverToRace(raceName, driverName);
    }

    private String startRace(String[] data) {
        // StartRace {race name}
        String raceName = data[0];
        return controller.startRace(raceName);
    }

    private String addCar(String[] data) {
        // AddCarToDriver {driver name} {car name}
        String driverName = data[0];
        String carModel = data[1];
        return controller.addCarToDriver(driverName, carModel);
    }

    private String createCar(String[] data) {
        // CreateCar {car type} {model} {horsepower}
        String type = data[0];
        String model = data[1];
        int horsePower = Integer.parseInt(data[2]);
        return controller.createCar(type, model, horsePower);
    }

    private String createDriver(String[] data) {
        //CreateDriver {name}
        String name = data[0];
        return controller.createDriver(name);
    }
}
