package main.java.Exam_11_December_2021.CatHouse.repositories;

import main.java.Exam_11_December_2021.CatHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

public class ToyRepository implements Repository<Toy> {
    private Collection<Toy> toys;

    public ToyRepository() {
        this.toys = new ArrayList<>();
    }

    @Override
    public void buyToy(Toy toy) {
        //Adds a toy to the collection.
        this.toys.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        //Removes a toy from the collection. Returns true if the deletion was successful, otherwise - false.
        return this.toys.remove(toy);
    }

    @Override
    public Toy findFirst(String type) {
        //Returns the first toy of the given type, if there is. Otherwise, returns null.
        return this.toys.stream().filter(e -> e.getClass().getSimpleName().equals(type))
                .findFirst().orElse(null);
    }
}
