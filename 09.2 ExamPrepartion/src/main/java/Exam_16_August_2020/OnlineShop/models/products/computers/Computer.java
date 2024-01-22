package main.java.Exam_16_August_2020.OnlineShop.models.products.computers;

import main.java.Exam_16_August_2020.OnlineShop.models.products.Product;
import main.java.Exam_16_August_2020.OnlineShop.models.products.components.Component;
import main.java.Exam_16_August_2020.OnlineShop.models.products.peripherals.Peripheral;

import java.util.List;

public interface Computer extends Product {
    List<Component> getComponents();

    List<Peripheral> getPeripherals();

    void addComponent(Component component);

    Component removeComponent(String componentType);

    void addPeripheral(Peripheral peripheral);

    Peripheral removePeripheral(String peripheralType);
}