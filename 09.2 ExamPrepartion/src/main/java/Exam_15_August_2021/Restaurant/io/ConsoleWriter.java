package main.java.Exam_15_August_2021.Restaurant.io;

import main.java.Exam_15_August_2021.Restaurant.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
