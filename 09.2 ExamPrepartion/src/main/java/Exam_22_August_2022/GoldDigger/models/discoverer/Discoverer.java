package main.java.Exam_22_August_2022.GoldDigger.models.discoverer;

import main.java.Exam_22_August_2022.GoldDigger.models.museum.Museum;

public interface Discoverer {
    String getName();

    double getEnergy();

    boolean canDig();

    Museum getMuseum();

    void dig();
}
