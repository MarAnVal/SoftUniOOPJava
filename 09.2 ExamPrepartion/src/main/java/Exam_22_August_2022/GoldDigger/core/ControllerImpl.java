package main.java.Exam_22_August_2022.GoldDigger.core;

import main.java.Exam_22_August_2022.GoldDigger.models.discoverer.*;
import main.java.Exam_22_August_2022.GoldDigger.models.operation.*;
import main.java.Exam_22_August_2022.GoldDigger.models.spot.*;
import main.java.Exam_22_August_2022.GoldDigger.repositories.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static main.java.Exam_22_August_2022.GoldDigger.common.ConstantMessages.*;
import static main.java.Exam_22_August_2022.GoldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SpotRepository spotRepository;

    private DiscovererRepository discovererRepository;
    int spotCount;

    public ControllerImpl() {
        this.spotRepository = new SpotRepository();
        this.discovererRepository = new DiscovererRepository();
        this.spotCount = 0;
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer = null;
        if (kind.equals(Archaeologist.class.getSimpleName())) {
            discoverer = new Archaeologist(discovererName);
        } else if (kind.equals(Anthropologist.class.getSimpleName())) {
            discoverer = new Anthropologist(discovererName);
        } else if (kind.equals(Geologist.class.getSimpleName())) {
            discoverer = new Geologist(discovererName);
        } else {
            throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }

        this.discovererRepository.add(discoverer);

        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);

        for (String s : exhibits) {
            spot.getExhibits().add(s);
        }

        this.spotRepository.add(spot);

        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = this.discovererRepository.byName(discovererName);

        if (discoverer == null) {
            throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        }

        this.discovererRepository.remove(discoverer);
        return String.format(DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        Spot spot = this.spotRepository.byName(spotName);

        Collection<Discoverer> collection = this.discovererRepository.getCollection();
        List<Discoverer> goingToMission = new ArrayList<>();

        for (Discoverer discoverer : collection) {
            if (discoverer.getEnergy() > 45) {
                goingToMission.add(discoverer);
            }
        }
        if (goingToMission.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        Operation operation = new OperationImpl();
        operation.startOperation(spot, goingToMission);
        int excluded = 0;
        for (Discoverer discoverer : goingToMission) {
            if (discoverer.getEnergy() == 0) {
                excluded++;
            } else {
                break;
            }
        }
        this.spotCount++;
        return String.format(INSPECT_SPOT, spotName, excluded);
    }

    @Override
    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        text.append(String.format(FINAL_SPOT_INSPECT, this.spotCount));
        text.append(System.lineSeparator());
        text.append(FINAL_DISCOVERER_INFO);

        Collection<Discoverer> discoverers = discovererRepository.getCollection();
        for (Discoverer discoverer : discoverers) {
            text.append(System.lineSeparator());
            text.append(String.format(FINAL_DISCOVERER_NAME, discoverer.getName()));
            text.append(System.lineSeparator());
            text.append(String.format(FINAL_DISCOVERER_ENERGY, discoverer.getEnergy()));
            text.append(System.lineSeparator());
            List<String> exhibits = (List<String>) discoverer.getMuseum().getExhibits();
            String finalExhibits = "None";
            if (!exhibits.isEmpty()) {
                finalExhibits = String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, exhibits);
            }
            text.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, finalExhibits));
        }
        return text.toString();
    }
}
