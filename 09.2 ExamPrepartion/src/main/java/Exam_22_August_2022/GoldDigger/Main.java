package main.java.Exam_22_August_2022.GoldDigger;

import main.java.Exam_22_August_2022.GoldDigger.core.*;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
