package main.java.Exam_20_December_2021.ChristmasRaces.entities.cars;

import static main.java.Exam_20_December_2021.ChristmasRaces.common.ExceptionMessages.INVALID_MODEL;

public abstract class BaseCar implements Car{
    //model - String
    private String model;
    //horsePower - int
    private int horsePower;
    //cubicCentimeters - double
    private double cubicCentimeters;
    //Every type of car has different cubic centimeters.

    public BaseCar(String model, int horsePower, double cubicCentimeters) {
        //If the model is null, whitespace, or less than 4 symbols,
        // throw an IllegalArgumentException with a message "Model {model} cannot be less than 4 symbols."
        if(model == null || model.trim().isEmpty() || model.length() < 4){
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, 4));
        }
        this.model = model;
        this.horsePower = horsePower;
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        //cubic centimeters / horsepower * laps
        return cubicCentimeters / (horsePower * laps);
    }
}
