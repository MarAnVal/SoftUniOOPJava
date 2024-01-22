package WildFarm.Animal;

import WildFarm.Food.Food;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    protected Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public double getAnimalWeight() {
        return animalWeight;
    }

    private void setFoodEaten(int foodEaten) {
        this.foodEaten += foodEaten;
    }

    public abstract void makeSound();
    public void eatFood(Food food){
        setFoodEaten(food.getQuantity());
    }
}
