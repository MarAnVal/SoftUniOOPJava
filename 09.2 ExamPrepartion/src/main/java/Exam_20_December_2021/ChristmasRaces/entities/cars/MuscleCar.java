package main.java.Exam_20_December_2021.ChristmasRaces.entities.cars;


import static main.java.Exam_20_December_2021.ChristmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class MuscleCar extends BaseCar{
    private int horsePower;
    //(String model, int horsePower, double cubicCentimeters)
    public MuscleCar(String model, int horsePower) {
        //The minimum horsepower is 400 and the maximum horsepower is 600.
        //If you receive horsepower which is not in the given range
        // throw IllegalArgumentException with the message "Invalid horse power: {horsepower}.".
        super(model,horsePower, 5000.0);
        if (horsePower < 400 || horsePower > 600){
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
    }
}
