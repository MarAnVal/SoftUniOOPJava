package main.java.Exam_22_August_2021.Farmville;

public class Animal {
    private String type;
    private double energy;

    public Animal(String type, double energy) {
        this.type = type;
        this.energy = energy;
    }

    public String getType() {
        return this.type;
    }

    public double getEnergy() {
        return this.energy;
    }
}
