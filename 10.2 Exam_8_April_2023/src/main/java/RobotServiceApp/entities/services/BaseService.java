package main.java.RobotServiceApp.entities.services;

import main.java.RobotServiceApp.entities.robot.Robot;
import main.java.RobotServiceApp.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static main.java.RobotServiceApp.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT;
import static main.java.RobotServiceApp.common.ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseService implements Service {
    //name - String
    private String name;
    //capacity -  int
    private int capacity;
    //The number of Robot а Service can have.
    //supplements - Collection<Supplement>
    private Collection<Supplement> supplements;
    //robots - Collection<Robot>
    private Collection<Robot> robots;

    //(String name, int capacity)

    public BaseService(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.robots = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        //If the name is null or whitespace, throw a NullPointerException with a message:
        //"Service name cannot be null or empty."
        //All names are unique.
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Robot> getRobots() {
        return this.robots;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public void addRobot(Robot robot) {
        //Adds a Robot in the Service if there is a capacity for it.
        if (this.capacity == robots.size()) {
            //If there is not enough capacity to add the Robot in the Service,
            // throw an IllegalStateException with the following message:
            //"Not enough capacity for this robot."
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }
        this.robots.add(robot);
    }

    @Override
    public void removeRobot(Robot robot) {
        //Removes a Robot from the Service.
        this.robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        //Adds a Supplements in the Service.
        this.supplements.add(supplement);
    }

    @Override
    public void feeding() {
        //The feeding() method feeds all robots in the Service.
        this.robots.forEach(Robot::eating);
    }

    @Override
    public int sumHardness() {
        //Returns the sum of each supplement’s hardness in the Service.
        int sum = 0;
        for (Supplement supplement : this.supplements) {
            sum += supplement.getHardness();
        }
        return sum;
    }

    @Override
    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        //Returns a String with information about the Service in the format below.
        //"{serviceName} {serviceType}:
        text.append(String.format("%s %s:", this.getName(), this.getClass().getSimpleName()));
        text.append(System.lineSeparator());
        List<String> robotsNames = new ArrayList<>();
        for (Robot robot : this.getRobots()) {
            robotsNames.add(robot.getName());
        }
        String robotsInService = "none";
        if (robotsNames.size() > 0) {
            robotsInService = String.join(" ", robotsNames);
        }
        //Robots: {robotName1} {robotName2} {robotName3} ... / Robots: none
        text.append(String.format("Robots: %s", robotsInService));
        text.append(System.lineSeparator());
        //Supplements: {supplementsCount} Hardness: {sumHardness}"
        text.append(String.format("Supplements: %d Hardness: %d", this.supplements.size(), this.sumHardness()));
        //Note: I remind you that there are two service types – MainService and SecondaryService.
        return text.toString();
    }
}
