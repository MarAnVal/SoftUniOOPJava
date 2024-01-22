package WildFarm.Animal;

import java.text.DecimalFormat;

abstract class Mammal extends Animal {
    String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.##");
        //Tiger[Tom, 167.7, Asia, 0]
        return String.format("%s[%s, %s, %s, %d]", this.getAnimalType(), this.getAnimalName(),
                df.format(this.getAnimalWeight()),
                this.getLivingRegion(), this.getFoodEaten());
    }
}
