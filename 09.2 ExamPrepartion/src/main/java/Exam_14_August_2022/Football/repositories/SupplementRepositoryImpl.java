package main.java.Exam_14_August_2022.Football.repositories;

import main.java.Exam_14_August_2022.Football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;

public class SupplementRepositoryImpl implements SupplementRepository{
    //supplements - Collection<Supplement>
    private Collection<Supplement> supplements;

    public SupplementRepositoryImpl() {
        this.supplements = new ArrayList<>();
    }

    @Override
    public void add(Supplement supplement) {
//Added a supplement to the collection.
        supplements.add(supplement);
    }

    @Override
    public boolean remove(Supplement supplement) {
        //Removes a supplement from the collection.
        // Returns true if the deletion was successful, otherwise - false.
        return supplements.remove(supplement);
    }

    @Override
    public Supplement findByType(String type) {
        //Returns the first supplement of the given type, if there is. Otherwise, returns null.
        for (Supplement supplement : supplements) {
            if(supplement.getClass().getSimpleName().equals(type)){
                return supplement;
            }
        }
        return null;
    }
}
