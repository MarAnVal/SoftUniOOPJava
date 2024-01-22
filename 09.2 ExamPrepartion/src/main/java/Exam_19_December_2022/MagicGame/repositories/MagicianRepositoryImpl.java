package main.java.Exam_19_December_2022.MagicGame.repositories;

import main.java.Exam_19_December_2022.MagicGame.models.magicians.Magician;
import main.java.Exam_19_December_2022.MagicGame.repositories.interfaces.MagicianRepository;

import java.util.ArrayList;
import java.util.Collection;

import static main.java.Exam_19_December_2022.MagicGame.common.ExceptionMessages.INVALID_MAGICIAN_REPOSITORY;

public class MagicianRepositoryImpl implements MagicianRepository<Magician> {
    private Collection<Magician> magicians;

    public MagicianRepositoryImpl() {
        this.magicians = new ArrayList<>();
    }

    @Override
    public Collection<Magician> getData() {
        return this.magicians;
    }

    @Override
    public void addMagician(Magician magician) {
        //If the magician is null,
        // throw a NullPointerException with a message: "Cannot add null in Magician Repository.".
        //· Adds a magician to the collection.
        if(magician==null){
            throw new NullPointerException(INVALID_MAGICIAN_REPOSITORY);
        }
        this.magicians.add(magician);
    }

    @Override
    public boolean removeMagician(Magician magician) {
        return this.magicians.remove(magician);
    }

    @Override
    public Magician findByUsername(String name) {
        return this.magicians.stream().filter(e->e.getUsername().equals(name)).
                findFirst().orElse(null);
    }
}
