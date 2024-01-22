package main.java.Exam_22_August_2021.GlacialExpedition.models.explorers;

import main.java.Exam_22_August_2021.GlacialExpedition.models.suitcases.Carton;
import main.java.Exam_22_August_2021.GlacialExpedition.models.suitcases.Suitcase;

import static main.java.Exam_22_August_2021.GlacialExpedition.common.ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO;
import static main.java.Exam_22_August_2021.GlacialExpedition.common.ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY;

public abstract class BaseExplorer implements Explorer{
    //name – String
    private String name;
    //energy –  double
    private double energy;
    //suitcase – Suitcase
    private Suitcase suitcase;

    //(String name, double energy)

    public BaseExplorer(String name, double energy) {
        //If the value of the name is either null or empty (containing only whitespaces),
        // throw a NullPointerException with the following message: "Explorer name cannot be null or empty."
        if(name==null||name.trim().isEmpty()){
            throw new NullPointerException(EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
        //If the energy is a negative number, throw an IllegalArgumentException with the following message:
        // "Cannot create Explorer with negative energy."
        if(energy < 0){
            throw new IllegalArgumentException(EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
        this.suitcase = new Carton();
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
    public boolean canSearch() {
        //The canSearch() method returns boolean. Tell us if the energy is more than zero.
        return this.energy > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    @Override
    public void search() {
        //The search() method decreases the explorer's energy.
        // Keep in mind that some Explorer types can implement the method differently.
        //The method decreases the explorer's energy by 15 units.
        this.energy --;
        //The energy value should not drop below zero.
        //Set the value to be zero if the energy value goes below zero.
        if(this.energy < 0){
            this.energy = 0;
        }
    }
}
