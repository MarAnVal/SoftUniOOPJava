package main.java.Exam_11_December_2021.CatHouse.entities.houses;

import main.java.Exam_11_December_2021.CatHouse.entities.cat.Cat;
import main.java.Exam_11_December_2021.CatHouse.entities.toys.Toy;

import java.util.Collection;

public interface House {
    int sumSoftness();

    void addCat(Cat cat);

    void removeCat(Cat cat);

    void buyToy(Toy toy);

    void feeding();

    String getStatistics();

    String getName();

    void setName(String name);

    Collection<Cat> getCats();

    Collection<Toy> getToys();
}
