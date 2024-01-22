package main.java.Exam_22_August_2021.GlacialExpedition.models.mission;

import main.java.Exam_22_August_2021.GlacialExpedition.models.explorers.Explorer;
import main.java.Exam_22_August_2021.GlacialExpedition.models.states.State;

import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission{

    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        //Explorers cannot go on expeditions if their energy is below 0.
        List<String> itemsToFind = (List<String>) state.getExhibits();
        for (Explorer explorer : explorers) {
            while (explorer.canSearch() && itemsToFind.size() > 0){
                //They leave the station and start collecting exhibits one by one.
                //If they find an exhibit, their energy is decreased.
                explorer.search();
                String found = itemsToFind.get(0);
                //They add the exhibit to their carton. The exhibit should then be removed from the state.
                explorer.getSuitcase().getExhibits().add(found);
                itemsToFind.remove(found);
                //Explorers cannot continue collecting exhibits if their energy drops to 0.
                //If their energy drops to 0, the next explorer starts exploring.
            }
            if(itemsToFind.isEmpty()){
                break;
            }
        }
    }
}
