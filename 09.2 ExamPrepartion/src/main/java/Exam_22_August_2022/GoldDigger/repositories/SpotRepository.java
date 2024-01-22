package main.java.Exam_22_August_2022.GoldDigger.repositories;

import main.java.Exam_22_August_2022.GoldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SpotRepository implements Repository<Spot> {
    List<Spot> spots;

    public SpotRepository() {
        this.spots = new ArrayList<>();
    }

    @Override
    public Collection getCollection() {
        return Collections.unmodifiableCollection(this.spots);
    }

    @Override
    public void add(Spot entity) {
        this.spots.add(entity);
    }

    @Override
    public boolean remove(Spot entity) {
        return this.spots.remove(entity);
    }

    @Override
    public Spot byName(String name) {
        for (Spot spot : this.spots) {
            if (spot.getName().equals(name)){
                return spot;
            }
        }
        return null;
    }
}