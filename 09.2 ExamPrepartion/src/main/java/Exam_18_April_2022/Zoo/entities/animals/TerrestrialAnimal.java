package main.java.Exam_18_April_2022.Zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal {
    //Can only live in LandArea!
    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, 5.5, price);
    }

    @Override
    public void eat() {
        //The method increases the animal’s kilograms by 5.70.
        for (int i = 0; i < 57; i++) {
            super.eat();
        }
    }
}
