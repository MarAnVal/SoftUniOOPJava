package main.java.Exam_16_August_2020.OnlineShop.core;

import main.java.Exam_16_August_2020.OnlineShop.core.interfaces.Controller;
import main.java.Exam_16_August_2020.OnlineShop.models.products.components.*;
import main.java.Exam_16_August_2020.OnlineShop.models.products.computers.*;
import main.java.Exam_16_August_2020.OnlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static main.java.Exam_16_August_2020.OnlineShop.common.constants.ExceptionMessages.*;
import static main.java.Exam_16_August_2020.OnlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Collection<Computer> computers;
    private Collection<Peripheral> peripherals;
    private Collection<Component> components;

    public ControllerImpl() {
        this.computers = new ArrayList<>();
        this.peripherals = new ArrayList<>();
        this.components = new ArrayList<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Computer computer = this.computers.stream().filter(e -> e.getId() == id)
                .findFirst().orElse(null);
        if (computer != null) {
            //If a computer, with the same id, already exists in the collection of the computer,
            // throw an IllegalArgumentException with the message "Computer with this id already exists."
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
        switch (computerType) {
            case "Laptop":
                computer = new Laptop(id, manufacturer, model, price);
                break;
            case "DesktopComputer":
                computer = new DesktopComputer(id, manufacturer, model, price);
                break;
            default:
                //If the computer type is invalid,
                // throw an IllegalArgumentException with the message "Computer type is invalid."
                throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
        //Creates a computer with the correct type and adds it to the collection of computers.
        this.computers.add(computer);
        //If it's successful, returns "Computer with id {id} added successfully."
        return String.format(ADDED_COMPUTER, computer.getId());
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer,
                                String model, double price, double overallPerformance, String connectionType) {
        //Creates a peripheral, with the correct type, and adds it to the computer with that id
        Peripheral peripheral = this.peripherals.stream().filter(e -> e.getId() == id)
                .findFirst().orElse(null);
        if (peripheral != null) {
            //If a peripheral, with the same id, already exists in the peripherals collection,
            // it throws an IllegalArgumentException with the message "Peripheral with this id already exists."
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                //If the peripheral type is invalid,
                // throw an IllegalArgumentException with the message "Peripheral type is invalid."
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        Computer computer = getComputerByID(computerId);
        // then adds it to the collection of peripherals in the controller.
        computer.addPeripheral(peripheral);
        this.peripherals.add(peripheral);
        //If it's successful, it returns:
        // "Peripheral {peripheral type} with id {peripheral id} added successfully in computer with id {computer id}."
        return String.format(ADDED_PERIPHERAL,
                peripheral.getClass().getSimpleName(),
                peripheral.getId(),
                computer.getId());
    }

    private Computer getComputerByID(int computerId) {
        Computer computer = this.computers.stream().filter(e -> e.getId() == computerId)
                .findFirst().orElse(null);
        if (computer == null) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        return computer;
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        //Removes a peripheral, with the given type from the computer with that id,
        // then removes the peripheral from the collection of peripherals.
        Computer computer = getComputerByID(computerId);
        Peripheral peripheral = computer.removePeripheral(peripheralType);
        this.peripherals.remove(peripheral);
        //If it's successful, it returns:
        // "Successfully removed {peripheral type} with id { peripheral id}.".
        return String.format(REMOVED_PERIPHERAL,
                peripheral.getClass().getSimpleName(),
                peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer,
                               String model, double price, double overallPerformance, int generation) {
        Component component = this.components.stream().filter(e -> e.getId() == id)
                .findFirst().orElse(null);
        if (component != null) {
            //If a component, with the same id, already exists in the components collection,
            // throws an IllegalArgumentException with the message "Component with this id already exists."
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                //If the component type is invalid,
                // throw an IllegalArgumentException with the message "Component type is invalid."
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }
        Computer computer = getComputerByID(computerId);
        //Creates a component with the correct type and adds it to the computer with that id,
        // then adds it to the collection of components in the controller.
        computer.addComponent(component);
        this.components.add(component);
        //If it's successful, returns:
        // "Component {component type} with id {component id} added successfully in computer with id {computer id}.".
        return String.format(ADDED_COMPONENT,
                component.getClass().getSimpleName(),
                component.getId(),
                computer.getId());
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        //Removes a component, with the given type from the computer with that id,
        Computer computer = getComputerByID(computerId);
        // then removes the component from the collection of components.
        Component component = computer.removeComponent(componentType);
        this.components.remove(component);
        //If it's successful, it returns:
        // "Successfully removed {component type} with id {component id}.".
        return String.format(REMOVED_COMPONENT,
                component.getClass().getSimpleName(),
                computer.getId());
    }

    @Override
    public String buyComputer(int id) {
        //Removes a computer, with the given id, from the collection of computers.
        Computer computer = getComputerByID(id);
        if (this.computers.remove(computer)) {
            //If it's successful, it returns toString method on the removed computer.
            return computer.toString();
        }
        return null;
    }

    @Override
    public String BuyBestComputer(double budget) {
        //Removes the computer with the highest overall performance and with a price,
        // less or equal to the budget, from the collection of computers.
        List<Computer> computersLessThanBudget = this.computers.stream().filter(e -> e.getPrice() <= budget)
                .collect(Collectors.toList());
        Computer computer = null;
        for (Computer computerLessThanBudget : computersLessThanBudget) {
            if (computer == null) {
                computer = computerLessThanBudget;
            }
            if (computerLessThanBudget.getOverallPerformance() > computer.getOverallPerformance()) {
                computer = computerLessThanBudget;
            }
        }
        if (computer == null) {
            //If there are not any computers in the collection or the budget is insufficient for any computer,
            // throw an IllegalArgumentException with the message "Can't buy a computer with a budget of ${budget}."
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }
        this.computers.remove(computer);
        //If it's successful, it returns toString method on the removed computer.
        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        //If it's successful, it returns toString method on the computer with the given id.
        Computer computer = getComputerByID(id);
        return computer.toString();
    }
}
