package main.java.Exam_14_August_2022.Football.entities.player;

import static main.java.Exam_14_August_2022.Football.common.ExceptionMessages.*;

public abstract class BasePlayer implements Player {
    //name - String
    private String name;
    //nationality -  String
    private String nationality;
    //kg -  double
    private double kg;
    //strength - int
    private int strength;

    public BasePlayer(String name, String nationality, double kg, int strength) {
        setName(name);

        if (nationality == null || nationality.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NATIONALITY_NULL_OR_EMPTY);
        }
        this.nationality = nationality;

        this.kg = kg;

        if (strength < 0) {
            throw new IllegalArgumentException(PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void stimulation(){
        this.strength++;
    }


    @Override
    public double getKg() {
        return this.kg;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }
}
