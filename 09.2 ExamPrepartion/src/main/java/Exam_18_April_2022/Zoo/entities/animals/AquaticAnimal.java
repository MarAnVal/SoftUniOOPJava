package main.java.Exam_18_April_2022.Zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal{
//Can only live in WaterArea!
    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, 2.5, price);
    }

    @Override
    public void eat() {
        //The method increases the animal’s kilograms by 7.50.
        for (int i = 0; i < 75; i++) {
            super.eat();
        }
    }
}
