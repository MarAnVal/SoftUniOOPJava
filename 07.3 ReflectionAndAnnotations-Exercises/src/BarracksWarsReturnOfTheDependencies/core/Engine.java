package BarracksWarsReturnOfTheDependencies.core;

import BarracksWarsReturnOfTheDependencies.core.commands.Command;
import BarracksWarsReturnOfTheDependencies.core.commands.NamedCommand;
import BarracksWarsReturnOfTheDependencies.interfaces.Repository;
import BarracksWarsReturnOfTheDependencies.interfaces.Runnable;
import BarracksWarsReturnOfTheDependencies.interfaces.UnitFactory;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Engine implements Runnable {
    private static final String COMMANDS_PACKAGE_NAME =
            "barracksWars.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;
    List<Class<?>> registeredCommands = new ArrayList<>();


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

    public void registerCommand(Class<?> commandClass) {
        NamedCommand annotation = commandClass.getAnnotation(NamedCommand.class);
        if (annotation == null) {
            throw new IllegalArgumentException("Expected" + commandClass.getSimpleName()
                    + " to have a " + NamedCommand.class.getSimpleName());
        }
        registeredCommands.add(commandClass);
    }

    private String interpretCommand(String[] data, String commandName) {
        Command command = buildCommand(data, commandName);
        if (command == null){
            throw new IllegalArgumentException("can't find command " + commandName);
        }
        return command.execute();
    }

    private Command buildCommand(String[] data, String commandName) {
        Command command = null;
        try {
            for (Class<?> registeredCommandClass : this.registeredCommands) {
                NamedCommand commandNameAnnotation = registeredCommandClass.getAnnotation(NamedCommand.class);
                if (commandNameAnnotation.commandName().equals(commandName)) {
                    command = (Command) registeredCommandClass.getConstructor(String[].class)
                            .newInstance((Object) data);
                    Optional<Field> repositoryField = Stream.of(registeredCommandClass.getDeclaredFields())
                            .filter(f -> f.getType().equals(Repository.class)).findFirst();
                    if(repositoryField.isPresent()){
                        Field field = repositoryField.get();
                        field.setAccessible(true);
                        field.set(command, this.repository);
                        field.setAccessible(false);
                    }
                    Optional<Field> unitFactoryField = Stream.of(registeredCommandClass.getDeclaredFields())
                            .filter(f -> f.getType().equals(UnitFactory.class)).findFirst();
                    if(unitFactoryField.isPresent()){
                        Field field = unitFactoryField.get();
                        field.setAccessible(true);
                        field.set(command, this.unitFactory);
                        field.setAccessible(false);
                    }

                    //TODO
                }
            }


        } catch (NoSuchMethodException
                 | InstantiationException
                 | IllegalAccessException
                 | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }

        return command;
    }
}
