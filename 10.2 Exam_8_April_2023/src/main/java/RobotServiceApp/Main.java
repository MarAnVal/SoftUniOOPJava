package main.java.RobotServiceApp;

import main.java.RobotServiceApp.core.Engine;
import main.java.RobotServiceApp.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
