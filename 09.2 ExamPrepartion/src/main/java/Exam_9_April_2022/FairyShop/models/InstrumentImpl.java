package main.java.Exam_9_April_2022.FairyShop.models;


import static main.java.Exam_9_April_2022.FairyShop.common.ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO;

public class InstrumentImpl implements Instrument{
    //power – int
    private int power;

    public InstrumentImpl(int power) {
        //If the initial power is below 0, throw an IllegalArgumentException with a message:
        // "Cannot create an Instrument with negative power!".
        if (power < 0){
            throw new IllegalArgumentException(INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void use() {
        //The use() method decreases the instrument's power by 10.
        //An instrument's power should not drop below 0. (If the power becomes less than 0, set it to 0).
        this.power -=10;
        if(this.power < 0){
            this.power = 0;
        }
    }

    @Override
    public boolean isBroken() {
        //This method returns true when power becomes equal to 0.
        return this.power == 0;
    }
}
