package main.java.Exam_22_August_2021.GlacialExpedition.core;

import main.java.Exam_22_August_2021.GlacialExpedition.models.explorers.AnimalExplorer;
import main.java.Exam_22_August_2021.GlacialExpedition.models.explorers.Explorer;
import main.java.Exam_22_August_2021.GlacialExpedition.models.explorers.GlacierExplorer;
import main.java.Exam_22_August_2021.GlacialExpedition.models.explorers.NaturalExplorer;
import main.java.Exam_22_August_2021.GlacialExpedition.models.mission.Mission;
import main.java.Exam_22_August_2021.GlacialExpedition.models.mission.MissionImpl;
import main.java.Exam_22_August_2021.GlacialExpedition.models.states.State;
import main.java.Exam_22_August_2021.GlacialExpedition.models.states.StateImpl;
import main.java.Exam_22_August_2021.GlacialExpedition.repositories.ExplorerRepository;
import main.java.Exam_22_August_2021.GlacialExpedition.repositories.Repository;
import main.java.Exam_22_August_2021.GlacialExpedition.repositories.StateRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static main.java.Exam_22_August_2021.GlacialExpedition.common.ConstantMessages.*;
import static main.java.Exam_22_August_2021.GlacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Explorer> explorerRepository;
    private Repository<State> stateRepository;
    private Mission mission;
    private int exploredStatesCount;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
        this.mission = new MissionImpl();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        //AddExplorer {explorerType} {explorerName}
        //Creates an explorer with the given name of the given type and saves it in the repository.
        //"NaturalExplorer" "GlacierExplorer" "AnimalExplorer"
        Explorer explorer = null;
        switch (type) {
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            default:
            // If the type is invalid, throw an IllegalArgumentException with the following message:
            //"Explorer type doesn't exists."
                throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }
        explorerRepository.add(explorer);
        //Otherwise, the method should return the following message:
        //"Added {type}: {explorerName}."
        return String.format(EXPLORER_ADDED, explorer.getClass().getSimpleName(), explorer.getName());
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        //AddState {stateName} {String... (Varargs)}
        State state = new StateImpl(stateName);
        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }
        //Creates a state with the provided exhibits and name and save it in the repository.
        stateRepository.add(state);
        //The method should return the following message:
        //"Added state: {stateName}."
        return String.format(STATE_ADDED, state.getName());
    }

    @Override
    public String retireExplorer(String explorerName) {
        //RetireExplorer {explorerName}
        //Retires the explorer from Antarctica by removing them from the repository.
        Explorer explorer = explorerRepository.getCollection().stream().filter(e -> e.getName().equals(explorerName))
                .findFirst().orElse(null);
        if(explorer == null) {
            // If an explorer with that name doesn’t exist, throw IllegalArgumentException with the following message:
            //"Explorer {explorerName} doesn't exists."
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        explorerRepository.remove(explorer);
        // If an explorer is successfully retired, remove them from the repository and return the following message:
        //"Explorer {explorerName} has retired!"
        return String.format(EXPLORER_RETIRED, explorer.getName());
    }

    @Override
    public String exploreState(String stateName) {
        //ExploreState {stateName}
        //When the explore command is called, the action happens. You should start exploring the
        // given state by sending the explorers that are most suitable for the mission:
        //You call each of the explorers and pick only the ones that have energy above 50 units.
        List<Explorer> explorersGoingToMission = explorerRepository.getCollection()
                .stream().filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());
        if (explorersGoingToMission.isEmpty()) {
            //If you don't have any suitable explorers, throw an IllegalArgumentException with the following message:
            // "You must have at least one explorer to explore the state."
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        State state = stateRepository.byName(stateName);
        mission.explore(state, explorersGoingToMission);
        exploredStatesCount++;
        //After a mission, you must return the following message with the name of the explored state and the count
        // of the explorers that had retired on the mission:
        List<Explorer> retired = explorersGoingToMission.stream()
                .filter(e -> e.getEnergy() == 0)
                .collect(Collectors.toList());
        //"The state {stateName} was explored. {retiredExplorers} researchers have retired on this mission."
        return String.format(STATE_EXPLORER, state.getName(), retired.size());
    }

    @Override
    public String finalResult() {
        //FinalResult
        StringBuilder text = new StringBuilder();
        //Returns the information about the explorers in the following format:
        Collection<Explorer> collection = explorerRepository.getCollection();
        //"{exploredStatesCount} states were explored.
        //Information for the explorers:
        text.append(String.format(FINAL_STATE_EXPLORED, exploredStatesCount));
        text.append(System.lineSeparator());
        text.append(FINAL_EXPLORER_INFO);
        Collection<Explorer> explorers = explorerRepository.getCollection();
        for (Explorer explorer : explorers) {
            text.append(System.lineSeparator());
            //Name: {explorerName}
            text.append(String.format(FINAL_EXPLORER_NAME,explorer.getName()));
            text.append(System.lineSeparator());
            //Energy: {explorerName}
            text.append(String.format(FINAL_EXPLORER_ENERGY, explorer.getEnergy()));
            text.append(System.lineSeparator());
            //Suitcase exhibits: {suitcaseExhibits1, suitcaseExhibits2, suitcaseExhibits3, …, suitcaseExhibits n}"
            //If the explorers don't have any suitcase exhibits, print "None" in their place.
            String exhibits = "None";
            List<String> exhibitsList = explorer.getSuitcase().getExhibits().stream().collect(Collectors.toList());
            if (!exhibitsList.isEmpty()){
                exhibits = String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, exhibitsList);
            }
            text.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, exhibits));
        }
        return text.toString();
    }
}
