package main.java.RobotServiceApp.core;

import main.java.RobotServiceApp.entities.robot.FemaleRobot;
import main.java.RobotServiceApp.entities.robot.MaleRobot;
import main.java.RobotServiceApp.entities.robot.Robot;
import main.java.RobotServiceApp.entities.services.MainService;
import main.java.RobotServiceApp.entities.services.SecondaryService;
import main.java.RobotServiceApp.entities.services.Service;
import main.java.RobotServiceApp.entities.supplements.MetalArmor;
import main.java.RobotServiceApp.repositories.SupplementRepository;
import main.java.RobotServiceApp.entities.supplements.PlasticArmor;
import main.java.RobotServiceApp.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static main.java.RobotServiceApp.common.ConstantMessages.*;
import static main.java.RobotServiceApp.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    //supplements - SupplementRepository
    private SupplementRepository supplements;
    //services - Collection<Service>
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        Service service = null;
        // Valid types are: "MainService" and "SecondaryService".
        switch (type) {
            case "SecondaryService":
                service = new SecondaryService(name);
                break;
            case "MainService":
                service = new MainService(name);
                break;
            default:
                //If the Service type is invalid, you have to
                // throw a NullPointerException with the following message: "Invalid service type."
                throw new NullPointerException(INVALID_SERVICE_TYPE);
        }
        //Creates and adds a Service to the services’ collection.
        this.services.add(service);
        //If the Service is added successfully, the method should return the following String:
        //"{serviceType} is successfully added."
        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, service.getClass().getSimpleName());
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement = null;
        // Valid types are: "PlasticArmor" and "MetalArmor".
        switch (type) {
            case "PlasticArmor":
                supplement = new PlasticArmor();
                break;
            case "MetalArmor":
                supplement = new MetalArmor();
                break;
            default:
                // If the supplement type is invalid, throw an IllegalArgumentException with a message:
                //"Invalid supplement type."
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        //Creates a supplement of the given type and adds it to the SupplementRepository.
        this.supplements.addSupplement(supplement);
        //The method should return the following string if the operation is successful:
        //"{supplementType} is successfully added."
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, supplement.getClass().getSimpleName());
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        //Adds the desired Supplement to the Service with the given name.
        Supplement supplement = supplements.findFirst(supplementType);
        if (supplement == null) {
            //If there is no such supplement, you have to throw an IllegalArgumentException with the following message:
            //"Supplement of type {supplementType} is missing."
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }
        Service service = services.stream().filter(e -> e.getName().equals(serviceName))
                .findFirst().orElse(null);
        // You have to remove the Supplement from the SupplementRepository if the insert is successful.
        service.addSupplement(supplement);
        supplements.removeSupplement(supplement);
        //If no exceptions are thrown, return the String:
        //"Successfully added {supplementType} to {serviceName}."
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplement.getClass().getSimpleName(), service.getName());
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot = null;
        // Valid Robot types are: "MaleRobot", "FemaleRobot".
        //Note: The method must first check whether the robot type is valid.
        switch (robotType) {
            case "FemaleRobot":
                robot = new FemaleRobot(robotName, robotKind, price);
                break;
            case "MaleRobot":
                robot = new MaleRobot(robotName, robotKind, price);
                break;
            default:
                //If the Robot type is invalid, you have to throw an IllegalArgumentException with the following message:
                //"Invalid robot type."
                throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }
        //If no errors are thrown, return one of the following strings:
        //"Unsuitable service." - if the given Robot cannot live in the Service.
        Service service = this.services.stream().filter(e -> e.getName().equals(serviceName))
                .findFirst().orElse(null);
        if ((robot.getClass().getSimpleName().equals("FemaleRobot") && service.getClass().getSimpleName().equals("MainService")) ||
                (robot.getClass().getSimpleName().equals("MaleRobot") && service.getClass().getSimpleName().equals("SecondaryService"))) {
            return String.format(UNSUITABLE_SERVICE);
        }
        //Creates and adds the desired Robot to the Service with the given name.
        service.addRobot(robot);
        //For reference: check their description from Task 1.
        //"Successfully added {robotType} to {serviceName}." - if the Robot is added successfully in the Service.
        return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robot.getClass().getSimpleName(), service.getName());
    }

    @Override
    public String feedingRobot(String serviceName) {
        //Feeds all Robot in the Service with the given name.
        Service service = this.services.stream().filter(e -> e.getName().equals(serviceName))
                .findFirst().orElse(null);
        service.feeding();
        //Returns a string with information about how many robots were successfully fed, in the following format:
        //"Robots fed: {fedCount}"
        return String.format(FEEDING_ROBOT, service.getRobots().size());
    }

    @Override
    public String sumOfAll(String serviceName) {
        //Calculates the value of the Service with the given name.
        Service service = this.services.stream().filter(e -> e.getName().equals(serviceName))
                .findFirst().orElse(null);
        double sumOfAll = 0;
        for (Robot robot : service.getRobots()) {
            sumOfAll += robot.getPrice();
        }
        for (Supplement supplement : service.getSupplements()) {
            sumOfAll += supplement.getPrice();
        }
        // It is calculated by the sum of all Robot and Supplement prices in the Service.
        //Return a string in the following format:
        //"The value of service {serviceName} is {value}."
        //The value should be formatted to the 2nd decimal place!
        return String.format(VALUE_SERVICE, service.getName(), sumOfAll);
    }

    @Override
    public String getStatistics() {
        //Returns information about each service.
        StringBuilder text = new StringBuilder();
        // You can use Service's getStatistics method to implement the current functionality.
        List<Service> serviceList = (List<Service>) this.services;
        for (int i = 0; i < serviceList.size(); i++) {
            //"{serviceName} {serviceType}:
            text.append(serviceList.get(i).getStatistics());
            if (i < serviceList.size() - 1){

                text.append(System.lineSeparator());
            }
        }

        //Robots: {robotName1} {robotName2} {robotName3} ... / Robots: none
        //Supplements: {supplementsCount} Hardness: {sumHardness}"
        //"{serviceName} {serviceType}:
        //Robots: {robotName1} {robotName2} {robotName3} ... / Robots: none
        //Supplements: {supplementsCount} Hardness: {sumHardness}"
        //..."
        return text.toString();
    }
}
