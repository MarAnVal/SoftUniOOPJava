package main.java.Exam_19_December_2022.MagicGame.repositories.interfaces;


import main.java.Exam_19_December_2022.MagicGame.models.magics.Magic;

import java.util.Collection;

public interface MagicRepository<T> {
    Collection<T> getData();

    void addMagic(Magic model);

    boolean removeMagic(Magic model);

    T findByName(String name);
}
