package main.java.Exam_20_December_2021.ChristmasRaces.entities.cars;

import static main.java.Exam_20_December_2021.ChristmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar{
    public SportsCar(String model, int horsePower) {
        super(model, horsePower, 3000.0);
        //The minimum horsepower is 250 and the maximum horsepower is 450.
        //If you receive horsepower which is not in the given range
        // throw IllegalArgumentException with the message "Invalid horse power: {horsepower}.".
        if (horsePower < 250 || horsePower > 450){
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
    }
}
