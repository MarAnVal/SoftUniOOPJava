package main.java.Exam_9_April_2022.FairyShop.models;

import java.util.ArrayList;
import java.util.Collection;

import static main.java.Exam_9_April_2022.FairyShop.common.ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY;


public class BaseHelper implements Helper{
    //name – String
    private String name;
    //energy –  int
    private int energy;
    //instruments – Collection<Instrument>
    private Collection<Instrument> instruments;

    public BaseHelper(String name, int energy) {
        //If the name is null or whitespace, throw a NullPointerException with a message:
        //"Helper name cannot be null or empty."
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(HELPER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
        this.energy = energy;
        this.instruments = new ArrayList<>();
    }

    @Override
    public void work() {
        //The work() method decreases helpers' energy by 10.
        //A helper's energy should not drop below 0 (If the power becomes less than 0, set it to 0).
        this.energy -= 10;
        if (this.energy < 0){
            this.energy = 0;
        }
    }

    @Override
    public void addInstrument(Instrument instrument) {
        //This method adds an instrument to the helper's collection of instruments.
        this.instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        //true - if the current energy of the helper is greater than 0;
        //false - otherwise.
        return this.energy > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return this.instruments;
    }
}
