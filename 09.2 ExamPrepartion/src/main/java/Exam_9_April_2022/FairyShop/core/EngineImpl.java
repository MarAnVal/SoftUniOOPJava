package main.java.Exam_9_April_2022.FairyShop.core;


import main.java.Exam_9_April_2022.FairyShop.common.Command;

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
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
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
            case AddHelper:
                result = addHelper(data);
                break;
            case AddPresent:
                result = addPresent(data);
                break;
            case AddInstrumentToHelper:
                result = addInstrumentToHelper(data);
                break;
            case CraftPresent:
                result = craftPresent(data);
                break;
            case Report:
                result = report();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }

    private String addHelper(String[] data) {
        //AddHelper {helperType} {helperName}
        String type = data[0];
        String helperName = data[1];
        return controller.addHelper(type, helperName);
    }

    private String addPresent(String[] data) {
        //AddPresent {presentName} {energyRequired}
        String presentName = data[0];
        int energyRequired = Integer.parseInt(data[1]);
        return controller.addPresent(presentName, energyRequired);
    }

    private String addInstrumentToHelper(String[] data) {
        //AddInstrumentToHelper {helperName} {power}
        String helperName = data[0];
        int power = Integer.parseInt(data[1]);
        return controller.addInstrumentToHelper(helperName, power);
    }

    private String report() {
        //Report
        return controller.report();
    }

    private String craftPresent(String[] data) {
        //CraftPresent {presentName}
        String presentName = data[0];
        return controller.craftPresent(presentName);
    }
}
