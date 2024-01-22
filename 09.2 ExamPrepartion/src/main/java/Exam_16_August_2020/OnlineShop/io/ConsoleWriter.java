package main.java.Exam_16_August_2020.OnlineShop.io;

import main.java.Exam_16_August_2020.OnlineShop.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
