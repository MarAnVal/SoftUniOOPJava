package main.java.Exam_9_April_2022.FairyShop.models;


import main.java.Exam_9_April_2022.FairyShop.common.ExceptionMessages;

public class PresentImpl implements Present{
    //name - String
    private String name;
    //energyRequired – int
    private int energyRequired;

    public PresentImpl(String name, int energyRequired) {
        //If the name is null or whitespace, throw a NullPointerException with a message:
        //"Present name cannot be null or empty.".
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.PRESENT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
        //If the initial energy is below 0, throw an IllegalArgumentException with a message:
        // "Cannot create a Present requiring negative energy!".
        if (energyRequired < 0){
            throw new IllegalArgumentException(ExceptionMessages.PRESENT_ENERGY_LESS_THAN_ZERO);
        }
        this.energyRequired = energyRequired;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergyRequired() {
        return this.energyRequired;
    }

    @Override
    public boolean isDone() {
        //The isDone() method returns true if the energyRequired reaches 0.
        return this.energyRequired == 0;
    }

    @Override
    public void getCrafted() {
        //The getCrafted() decreases the required energy of the present by 10 units.
        //A present's required energy should not drop below 0 (If the energy becomes less than 0, set it to 0).
        this.energyRequired -= 10;
        if (this.energyRequired < 0){
            this.energyRequired = 0;
        }
    }
}
