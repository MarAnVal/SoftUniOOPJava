package main.java.RobotServiceApp.entities.robot;

import static main.java.RobotServiceApp.common.ExceptionMessages.*;

public abstract class BaseRobot implements Robot{
    //name - String
    private String name;
    //kind - String
    private String kind;
    //kilograms - int
    private int kilograms;
    //price - double
    private double price;

    //(String name, String kind, int kilograms, double price)

    public BaseRobot(String name, String kind, int kilograms, double price) {
        this.setName(name);
        //If the kind is null or whitespace, throw a NullPointerException with a message:
        //"Robot kind cannot be null or empty."
        if(kind==null||kind.trim().isEmpty()){
            throw new NullPointerException(ROBOT_KIND_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.kind = kind;
        this.kilograms = kilograms;
        //If the price is below or equal to 0, throw an IllegalArgumentException with a message:
        // "Robot price cannot be below or equal to 0."
        if(price<=0){
            throw new IllegalArgumentException(ROBOT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if(name==null||name.trim().isEmpty()){
            throw new NullPointerException(ROBOT_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getKilograms() {
        return this.kilograms;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void eating() {
        //The eating() method increases the Robot’s kilograms.
        // Keep in mind that some kinds of Robot can implement the method differently.
        this.kilograms++;
    }
}
