package main.java.Exam_20_December_2021.ChristmasRaces.io;

import main.java.Exam_20_December_2021.ChristmasRaces.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
