package main.java.Exam_22_August_2021.GlacialExpedition.repositories;

import main.java.Exam_22_August_2021.GlacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ExplorerRepository implements Repository<Explorer> {
    //explorers – a collection of explorers
    private Collection<Explorer> explorers;

    public ExplorerRepository() {
        this.explorers = new ArrayList<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        //Returns an unmodifiable collection of explorers.
        return Collections.unmodifiableCollection(this.explorers);
    }

    @Override
    public void add(Explorer explorer) {
        //Adds an explorer to the station.
        //Every explorer is unique in the collection.
        //It is guaranteed that there will not be an explorer with the same name.
        this.explorers.add(explorer);
    }

    @Override
    public boolean remove(Explorer explorer) {
        //Removes an explorer from the collection. Returns true if the deletion was successful.
        return this.explorers.remove(explorer);
    }

    @Override
    public Explorer byName(String name) {
        //Returns an explorer with that name.
        //If the explorer is not in the collection, return null.
        return this.explorers.stream().filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
    }
}
