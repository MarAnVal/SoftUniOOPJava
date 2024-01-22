package main.java.Exam_22_August_2021.GlacialExpedition.models.mission;

import main.java.Exam_22_August_2021.GlacialExpedition.models.explorers.Explorer;
import main.java.Exam_22_August_2021.GlacialExpedition.models.states.State;

import java.util.Collection;

public interface Mission {
    void explore(State state, Collection<Explorer> explorers);
}
