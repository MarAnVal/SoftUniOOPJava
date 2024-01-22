package main.java.RobotServiceApp.repositories;

import main.java.RobotServiceApp.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;

public class SupplementRepository implements Repository {
    //supplements - Collection<Supplement>
    private Collection<Supplement> supplements;

    public SupplementRepository() {
        this.supplements = new ArrayList<>();
    }

    @Override
    public void addSupplement(Supplement supplement) {
        //Adds a supplement to the collection.
        this.supplements.add(supplement);
    }

    @Override
    public boolean removeSupplement(Supplement supplement) {
        //Removes a supplement from the collection.
        // Returns true if the deletion was successful, otherwise - false.
        return this.supplements.remove(supplement);
    }

    @Override
    public Supplement findFirst(String type) {
        //Returns the first supplement of the given type, if there is any. Otherwise, returns null.
        return this.supplements.stream().filter(e->e.getClass().getSimpleName().equals(type))
                .findFirst().orElse(null);
    }
}
