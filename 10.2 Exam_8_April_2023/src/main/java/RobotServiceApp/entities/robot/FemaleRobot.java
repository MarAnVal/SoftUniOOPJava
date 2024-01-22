package main.java.RobotServiceApp.entities.robot;

public class FemaleRobot extends BaseRobot{
    //Can only live in SecondaryService!
    public FemaleRobot(String name, String kind,double price) {
        super(name, kind, 7, price);
    }
}
