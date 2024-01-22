package main.java.Exam_16_August_2020.OnlineShop;

import main.java.Exam_16_August_2020.OnlineShop.core.EngineImpl;
import main.java.Exam_16_August_2020.OnlineShop.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
