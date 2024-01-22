package main.java.Exam_11_December_2021.CatHouse.repositories;

import main.java.Exam_11_December_2021.CatHouse.entities.toys.Toy;

public interface Repository<T> {

    void buyToy(Toy toy);

    boolean removeToy(Toy toy);

    Toy findFirst(String type);
}
