package BarracksWarsTheCommandsStrikeBack.core;

import BarracksWarsTheCommandsStrikeBack.core.commands.Command;
import BarracksWarsTheCommandsStrikeBack.interfaces.Repository;
import BarracksWarsTheCommandsStrikeBack.interfaces.Runnable;
import BarracksWarsTheCommandsStrikeBack.interfaces.UnitFactory;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {
    private static final String COMMANDS_PACKAGE_NAME =
            "BarracksWarsTheCommandsStrikeBack.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;


    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String interpretCommand(String[] data, String commandName) {
        try {
            String commandClassName = commandName.substring(0, 1).toUpperCase() + commandName.substring(1) + "Command";
            Class<?> aClass = Class.forName(COMMANDS_PACKAGE_NAME + commandClassName);
            Constructor<?> constructor = aClass.getConstructor(String[].class, Repository.class, UnitFactory.class);
            Command command = (Command) constructor.newInstance(data, repository, unitFactory);
            return command.execute();
        } catch (ClassNotFoundException
                 | NoSuchMethodException
                 | InstantiationException
                 | IllegalAccessException
                 | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }
}
