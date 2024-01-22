package WildFarm;

import WildFarm.Animal.*;
import WildFarm.Food.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();
        List<Food> foods = new ArrayList<>();
        String line = scanner.nextLine();
        while (!line.equals("End")) {
            Animal animal = getAnimal(line);
            line = scanner.nextLine();
            Food food = getFood(line);
            animals.add(animal);
            foods.add(food);
            line = scanner.nextLine();
        }

        for (int i = 0; i < animals.size(); i++) {
            animals.get(i).makeSound();
            animals.get(i).eatFood(foods.get(i));
        }
        animals.forEach(System.out::println);
    }


    private static Food getFood(String line) {
        String[] parts = line.split("\\s+");
        Food food;
        switch (parts[0]) {
            case "Meat":
                food = new Meat(Integer.parseInt(parts[1]));
                break;
            case "Vegetable":
                food = new Vegetable(Integer.parseInt(parts[1]));
                break;
            default:
                throw new IllegalArgumentException("Unknown food type: " + parts[0]);
        }
        return food;
    }

    private static Animal getAnimal(String line) {
        String[] parts = line.split("\\s+");
        Animal animal;
        switch (parts[0]) {
            case "Cat":
                //Cat Gray 1.1 Home Persian
                animal = new Cat(parts[1], parts[0], Double.parseDouble(parts[2]), parts[3], parts[4]);
                break;
            case "Tiger":
                animal = new Tiger(parts[1], parts[0], Double.parseDouble(parts[2]), parts[3]);
                break;
            case "Zebra":
                animal = new Zebra(parts[1], parts[0], Double.parseDouble(parts[2]), parts[3]);
                break;
            case "Mouse":
                animal = new Mouse(parts[1], parts[0], Double.parseDouble(parts[2]), parts[3]);
                break;
            default:
                throw new IllegalArgumentException("Unknown animal type: " + parts[0]);
        }
        return animal;
    }
}
