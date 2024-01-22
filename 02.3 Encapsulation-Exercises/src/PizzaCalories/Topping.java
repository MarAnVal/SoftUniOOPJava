package PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        //toppings can be of type Meat, Veggies, Cheese, or Sauce
        //"Cannot place {name of invalid argument} on top of your pizza."
        if (!(toppingType.equals("Meat") || toppingType.equals("Veggies") ||
                toppingType.equals("Cheese") || toppingType.equals("Sauce"))) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        //"{Topping type name} weight should be in the range [1..50]."
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    //+ calculateCalories (): double
    public double calculateCalories() {
        double topping = 0.0;
        switch (this.toppingType) {
            //· Meat – 1.2;
            case "Meat":
                topping = 1.2;
                break;
            //· Veggies – 0.8;
            case "Veggies":
                topping = 0.8;
                break;
            //· Cheese – 1.1;
            case "Cheese":
                topping = 1.1;
                break;
            //· Sauce – 0.9;
            case "Sauce":
                topping = 0.9;
                break;
        }
        double base = 2.0;
        return this.weight * base * topping;
    }
}