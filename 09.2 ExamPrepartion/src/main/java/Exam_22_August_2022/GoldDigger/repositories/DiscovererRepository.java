package main.java.Exam_22_August_2022.GoldDigger.repositories;

import main.java.Exam_22_August_2022.GoldDigger.models.discoverer.Discoverer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DiscovererRepository implements Repository<Discoverer>{
private List<Discoverer> discoverers;

    public DiscovererRepository() {
        this.discoverers = new ArrayList<>();
    }

    @Override
    public Collection<Discoverer> getCollection() {
        return Collections.unmodifiableCollection(this.discoverers);
    }

    @Override
    public void add(Discoverer entity) {
        discoverers.add(entity);
    }

    @Override
    public boolean remove(Discoverer entity) {
        return this.discoverers.remove(entity);
    }

    @Override
    public Discoverer byName(String name) {
        for (Discoverer currentDiscoverer : this.discoverers) {
            if(currentDiscoverer.getName().equals(name)){
                return currentDiscoverer;
            }
        }
        return null;
    }
}
