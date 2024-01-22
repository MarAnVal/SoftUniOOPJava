package main.java.Exam_20_December_2021.ChristmasRaces.repositories;

import main.java.Exam_20_December_2021.ChristmasRaces.entities.races.Race;
import main.java.Exam_20_December_2021.ChristmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceRepository<T extends Race> implements Repository<T> {
    private Collection<T> races;

    public RaceRepository() {
        this.races = new ArrayList<>();
    }

    @Override
    public T getByName(String name) {
        for (Race race : this.races) {
            if(race.getName().equals(name)){
                return (T) race;
            }
        }
        return null;
    }

    @Override
    public Collection<T> getAll() {
        return Collections.unmodifiableCollection(this.races);
    }

    @Override
    public void add(T race) {
        this.races.add(race);
    }

    @Override
    public boolean remove(T race) {
        return this.races.remove(race);
    }
}
