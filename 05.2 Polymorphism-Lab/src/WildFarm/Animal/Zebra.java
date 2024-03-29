package WildFarm.Animal;

import WildFarm.Food.*;

public class Zebra extends Mammal{
    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eatFood(Food food) {
        if (!food.getClass().getSimpleName().equals(Vegetable.class.getSimpleName())){
            //"{AnimalType} are not eating that type of food!"
            System.out.printf("%ss are not eating that type of food!%n", this.getAnimalType());
        } else {
            super.eatFood(food);
        }
    }
}
