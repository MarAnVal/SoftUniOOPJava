package main.java.Exam_22_August_2022.GoldDigger.models.discoverer;

import main.java.Exam_22_August_2022.GoldDigger.models.museum.BaseMuseum;
import main.java.Exam_22_August_2022.GoldDigger.models.museum.Museum;

import static main.java.Exam_22_August_2022.GoldDigger.common.ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO;
import static main.java.Exam_22_August_2022.GoldDigger.common.ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY;

public abstract class BaseDiscoverer implements Discoverer {
    private String name;
    //If the value of the name is either null or empty (containing only whitespaces), throw a NullPointerException with the following message: "Discoverer name cannot be null or empty."
    //The values of the names are unique.
    private double energy;
    //If the energy is a negative number, throw an IllegalArgumentException
    // with the following message: "Cannot create Discoverer with negative energy."
    private Museum museum;

    public BaseDiscoverer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.museum = new BaseMuseum();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canDig() {
        return this.energy > 0;
    }

    @Override
    public Museum getMuseum() {
        return this.museum;
    }

    @Override
    public void dig() {this.energy -= 15;
        if (this.energy < 0) {
            setEnergy(0);
        }
    }
}
