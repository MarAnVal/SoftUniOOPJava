package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
    }

    private void setName(String name) {
        //name of the pizza is empty, only whitespace or longer than 15 symbols throw an exception
        //"Pizza name should be between 1 and 15 symbols."
        if (name == null || name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int numberOfToppings) {
        //number of toppings are in the range [0..10]
        //"Number of toppings should be in range [0..10]."
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    //+ addTopping (Topping) : void
    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    //+ getOverallCalories () : double
    public double getOverallCalories() {
        double doughCalories = this.dough.calculateCalories();
        double toppingCalories = 0;
        for (Topping topping : this.toppings) {
            toppingCalories += topping.calculateCalories();
        }
        return doughCalories + toppingCalories;
    }
}