package main.java.Exam_22_August_2021.GlacialExpedition.models.explorers;

import main.java.Exam_22_August_2021.GlacialExpedition.models.suitcases.Suitcase;

public interface Explorer {
    String getName();

    double getEnergy();

    boolean canSearch();

    Suitcase getSuitcase();

    void search();
}
