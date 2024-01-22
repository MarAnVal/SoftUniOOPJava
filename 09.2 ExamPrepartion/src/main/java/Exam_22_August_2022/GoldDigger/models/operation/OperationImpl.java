package main.java.Exam_22_August_2022.GoldDigger.models.operation;

import main.java.Exam_22_August_2022.GoldDigger.models.discoverer.Discoverer;
import main.java.Exam_22_August_2022.GoldDigger.models.spot.Spot;

import java.util.Collection;
import java.util.List;

public class OperationImpl implements Operation {
    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        List<String> itemsToFind = (List<String>) spot.getExhibits();

            for (Discoverer discoverer : discoverers) {
                while (discoverer.canDig() && !itemsToFind.isEmpty()) {
                    discoverer.dig();
                    discoverer.getMuseum().getExhibits().add(itemsToFind.get(0));
                    itemsToFind.remove(0);
                }
                if (itemsToFind.isEmpty()){
                    break;
                }
            }

    }
}
