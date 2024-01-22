package main.java.Exam_22_August_2021.GlacialExpedition;

import main.java.Exam_22_August_2021.GlacialExpedition.core.Controller;
import main.java.Exam_22_August_2021.GlacialExpedition.core.ControllerImpl;
import main.java.Exam_22_August_2021.GlacialExpedition.core.Engine;
import main.java.Exam_22_August_2021.GlacialExpedition.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
