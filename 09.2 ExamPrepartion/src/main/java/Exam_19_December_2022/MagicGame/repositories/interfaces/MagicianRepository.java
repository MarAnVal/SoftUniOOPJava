package main.java.Exam_19_December_2022.MagicGame.repositories.interfaces;


import main.java.Exam_19_December_2022.MagicGame.models.magicians.Magician;

import java.util.Collection;

public interface MagicianRepository<T> {
    Collection<T> getData();

    void addMagician(Magician model);

    boolean removeMagician(Magician model);

    T findByUsername(String name);
}
