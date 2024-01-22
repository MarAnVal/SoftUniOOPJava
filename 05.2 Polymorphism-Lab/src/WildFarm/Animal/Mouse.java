package WildFarm.Animal;

import WildFarm.Food.*;

public class Mouse extends Mammal{
    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eatFood(Food food) {
        if (!food.getClass().getSimpleName().equals(Vegetable.class.getSimpleName())){
            //"{AnimalType} are not eating that type of food!"
            System.out.printf("Mice are not eating that type of food!%n");
        } else {
            super.eatFood(food);
        }
    }
}
