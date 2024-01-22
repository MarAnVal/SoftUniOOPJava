package main.java.RobotServiceApp.repositories;

import main.java.RobotServiceApp.entities.supplements.Supplement;

public interface Repository {

    void addSupplement(Supplement supplement);

    boolean removeSupplement(Supplement supplement);

    Supplement findFirst(String type);
}
