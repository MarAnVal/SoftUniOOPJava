package main.java.Exam_14_August_2022.Football.repositories;

import main.java.Exam_14_August_2022.Football.entities.supplement.Supplement;

public interface SupplementRepository {
    void add(Supplement supplement);

    boolean remove(Supplement supplement);

    Supplement findByType(String type);
}
