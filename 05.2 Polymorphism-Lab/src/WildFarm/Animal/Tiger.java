package WildFarm.Animal;

import WildFarm.Food.*;

public class Tiger extends Felime {
    private String livingRegion;

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.livingRegion = livingRegion;
    }

    @Override
    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eatFood(Food food) {
        if (!food.getClass().getSimpleName().equals(Meat.class.getSimpleName())){
            //"{AnimalType} are not eating that type of food!"
            System.out.printf("%ss are not eating that type of food!%n", this.getAnimalType());
        } else {
            super.eatFood(food);
        }
    }
}
