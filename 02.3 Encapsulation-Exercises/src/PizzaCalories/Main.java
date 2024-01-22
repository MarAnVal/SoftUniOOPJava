package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int numberOfToppings = Integer.parseInt(line.split("\\s+")[2]);
        Pizza pizza = getPizza(line);
        line = scanner.nextLine();
        Dough dough = getDough(line);

        if (pizza != null && dough != null) {
            pizza.setDough(dough);
            line = scanner.nextLine();
            int count = 0;
            while (!line.equals("END") && count < numberOfToppings) {
                Topping topping = getTopping(line);
                if (topping != null) {
                    pizza.addTopping(topping);
                    line = scanner.nextLine();
                    count++;
                    continue;
                }
                pizza = null;
                break;
            }
            if (pizza != null) {
                System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());
            }
        }
    }

    private static Topping getTopping(String line) {
        String toppingType = line.split("\\s+")[1];
        double weight = Double.parseDouble(line.split("\\s+")[2]);
        Topping topping = null;
        try {
            topping = new Topping(toppingType, weight);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return topping;
    }

    private static Dough getDough(String line) {
        String flourType = line.split("\\s+")[1];
        String bakingTechnique = line.split("\\s+")[2];
        double weight = Double.parseDouble(line.split("\\s+")[3]);
        Dough dough = null;
        try {
            dough = new Dough(flourType, bakingTechnique, weight);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dough;
    }

    private static Pizza getPizza(String line) {
        String name = line.split("\\s+")[1];
        int numberOfToppings = Integer.parseInt(line.split("\\s+")[2]);
        Pizza pizza = null;
        try {
            pizza = new Pizza(name, numberOfToppings);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pizza;
    }
}
