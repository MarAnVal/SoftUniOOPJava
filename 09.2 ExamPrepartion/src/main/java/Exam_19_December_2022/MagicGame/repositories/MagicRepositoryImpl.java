package main.java.Exam_19_December_2022.MagicGame.repositories;

import main.java.Exam_19_December_2022.MagicGame.models.magics.Magic;
import main.java.Exam_19_December_2022.MagicGame.repositories.interfaces.MagicRepository;

import java.util.ArrayList;
import java.util.Collection;

import static main.java.Exam_19_December_2022.MagicGame.common.ExceptionMessages.INVALID_MAGIC_REPOSITORY;

public class MagicRepositoryImpl implements MagicRepository<Magic> {
    private Collection<Magic> magics;

    public MagicRepositoryImpl() {
        this.magics = new ArrayList<>();
    }

    @Override
    public Collection<Magic> getData() {
        return this.magics;
    }

    @Override
    public void addMagic(Magic magic) {
        //· If the magic is null,
        // throw a NullPointerException with a message: "Cannot add null in Magic Repository."
        //· Adds a magic to the collection.
        if(magic==null){
            throw new NullPointerException(INVALID_MAGIC_REPOSITORY);
        }
        this.magics.add(magic);
    }

    @Override
    public boolean removeMagic(Magic magic) {
        //Removes a magic from the collection.
        // Returns true if the removal was successful, otherwise - fals
        return this.magics.remove(magic);
    }

    @Override
    public Magic findByName(String name) {
        //Returns the first magic with the given name, if there is such a magic. Otherwise, returns nul
        return this.magics.stream().filter(e->e.getName().equals(name))
                .findFirst().orElse(null);
    }
}
