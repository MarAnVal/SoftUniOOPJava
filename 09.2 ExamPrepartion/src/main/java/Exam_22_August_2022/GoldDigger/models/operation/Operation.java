package main.java.Exam_22_August_2022.GoldDigger.models.operation;

import main.java.Exam_22_August_2022.GoldDigger.models.discoverer.Discoverer;
import main.java.Exam_22_August_2022.GoldDigger.models.spot.Spot;

import java.util.Collection;

public interface Operation {
    void startOperation(Spot spot, Collection<Discoverer> discoverers);

}
