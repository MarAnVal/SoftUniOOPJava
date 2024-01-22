package main.java.Exam_9_April_2022.FairyShop.repositories;

import main.java.Exam_9_April_2022.FairyShop.models.Helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HelperRepository implements Repository<Helper>{
    //helpers – a collection of helpers
    private List<Helper> helpers;

    public HelperRepository() {
        this.helpers = new ArrayList<>();
    }

    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableList(this.helpers);
    }

    @Override
    public void add(Helper helper) {
        //Adds a helper to the collection.
        //Every helper is unique it is guaranteed that there will not be a helper with the same name.
        this.helpers.add(helper);
    }

    @Override
    public boolean remove(Helper helper) {
        //Removes a helper from the collection.
        //Returns true if the deletion was successful.
        return helpers.remove(helper);
    }

    @Override
    public Helper findByName(String name) {
        return this.helpers.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }
}
