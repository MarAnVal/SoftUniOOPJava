package main.java.Exam_16_August_2020.OnlineShop.models.products.computers;

import main.java.Exam_16_August_2020.OnlineShop.models.products.BaseProduct;
import main.java.Exam_16_August_2020.OnlineShop.models.products.components.Component;
import main.java.Exam_16_August_2020.OnlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static main.java.Exam_16_August_2020.OnlineShop.common.constants.ExceptionMessages.*;
import static main.java.Exam_16_August_2020.OnlineShop.common.constants.OutputMessages.COMPUTER_COMPONENTS_TO_STRING;
import static main.java.Exam_16_August_2020.OnlineShop.common.constants.OutputMessages.COMPUTER_PERIPHERALS_TO_STRING;

public abstract class BaseComputer extends BaseProduct implements Computer {
    //components – List
    private List<Component> components;
    //peripherals – List
    private List<Peripheral> peripherals;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        //If the components collection contains a component with the same component type,
        Component componentExist = this.components.stream()
                .filter(e -> e.getClass().getSimpleName().equals(component.getClass().getSimpleName()))
                .findFirst().orElse(null);
        if (componentExist != null) {
            // throw an IllegalArgumentException with the message
            // "Component {component type} already exists in {computer type} with Id {id}."
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,
                    component.getClass().getSimpleName(),
                    this.getClass().getSimpleName(),
                    this.getId()));
        }
        //Otherwise, add the component to the component collection.
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        Component component = this.components.stream()
                .filter(e -> e.getClass().getSimpleName().equals(componentType))
                .findFirst().orElse(null);
        if (component == null) {
            //If the components collection is empty or does not have a component of that type,
            // throw an IllegalArgumentException with the message
            // "Component {component type} does not exist in {computer type} with Id {id}."
            throw new IllegalArgumentException(String
                    .format(NOT_EXISTING_COMPONENT,
                            componentType,
                            this.getClass().getSimpleName(),
                            this.getId()));
        }
        //Otherwise, remove the component of that type and return it.
        this.components.remove(component);
        return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        Peripheral peripheralExist = this.peripherals.stream()
                .filter(e -> e.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName()))
                .findFirst().orElse(null);
        if (peripheralExist != null) {
            //If the peripherals collection contains a peripheral with the same peripheral type,
            // throw an IllegalArgumentException with the message:
            // "Peripheral {peripheral type} already exists in {computer type} with Id {id}."
            throw new IllegalArgumentException(String
                    .format(EXISTING_PERIPHERAL,
                            peripheral.getClass().getSimpleName(),
                            this.getClass().getSimpleName(),
                            this.getId()));
        }
        //Otherwise, add the peripheral to the peripheral collection.
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        Peripheral peripheral = this.peripherals.stream()
                .filter(e -> e.getClass().getSimpleName().equals(peripheralType))
                .findFirst().orElse(null);
        if (peripheral == null) {
            //If the peripherals collection is empty or does not have a peripheral of that type,
            // throw an IllegalArgumentException with the message:
            // "Peripheral {peripheral type} does not exist in {computer type} with Id {id}."
            throw new IllegalArgumentException(String
                    .format(NOT_EXISTING_PERIPHERAL,
                            peripheralType,
                            this.getClass().getSimpleName(),
                            this.getId()));
        }
        //Otherwise, remove the peripheral of that type and return it.
        this.peripherals.remove(peripheral);
        return peripheral;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        //"Overall Performance: {overall performance}. Price: {price} - {product type}: {manufacturer} {model} (Id: {id})"
        text.append(super.toString());
        text.append(System.lineSeparator());
        //" Components ({components count}):"
        text.append(String.format(" %s",
                String.format(COMPUTER_COMPONENTS_TO_STRING, this.components.size())));
        text.append(System.lineSeparator());
        for (Component component : this.components) {
            //"  {component one}"
            //"  {component two}"
            //"  {component n}"
            text.append(String.format("  %s", component.toString()));
            text.append(System.lineSeparator());
        }
        //" Peripherals ({peripherals count}); Average Overall Performance ({average overall performance peripherals}):"
        double average = 0;
        for (Peripheral peripheral : this.peripherals) {
            average += peripheral.getOverallPerformance();
        }
        if(!peripherals.isEmpty()) {
            average /= peripherals.size();
        }
        text.append(String.format(" %s",
                String.format(COMPUTER_PERIPHERALS_TO_STRING, this.peripherals.size(), average)));
        for (Peripheral peripheral : this.peripherals) {
            //"  {peripheral one}"
            //"  {peripheral two}"
            //"  {peripheral n}"
            text.append(System.lineSeparator());
            text.append(String.format("  %s", peripheral.toString()));
            text.append(System.lineSeparator());
        }
        //Note: Be careful, some of the rows have one or two whitespaces at the beginning of the sentences!
        return text.toString();
    }

    @Override
    public double getOverallPerformance() {
        //Override the base functionality (if the components collection is empty,
        // it should return only the computer overall performance,
        //if the components collection is empty,
        // it should return only the computer overall performance,
        // otherwise return the sum of the computer overall performance and the
        // average overall performance from all components)
        double componentsPerformance = 0;
        for (Component component : this.components) {
            componentsPerformance += component.getOverallPerformance();
        }
        if(!this.components.isEmpty()){
            componentsPerformance /= this.components.size();
        }
        return super.getOverallPerformance() + componentsPerformance;
    }

    @Override
    public double getPrice() {
        //Override the base functionality (The price is equal to the total sum of the computer
        // price with the sum of all component prices and the sum of all peripheral prices)
        double addonsPrice = 0;
        for (Component component : this.components) {
            addonsPrice += component.getPrice();
        }
        for (Peripheral peripheral : this.peripherals) {
            addonsPrice += peripheral.getPrice();
        }
        return super.getPrice() + addonsPrice;
    }
}
