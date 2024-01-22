package main.java.Exam_22_August_2021.GlacialExpedition.models.states;

import java.util.ArrayList;
import java.util.Collection;

import static main.java.Exam_22_August_2021.GlacialExpedition.common.ExceptionMessages.STATE_NAME_NULL_OR_EMPTY;

public class StateImpl implements State{
    //name – String
    private String name;
    //exhibits – a collection of Strings
    private Collection<String> exhibits;

    public StateImpl(String name) {
        //If the value of the name is either null or empty (containing only whitespaces),
        // throw a NullPointerException with the following message: "Invalid name!"
        if(name == null||name.trim().isEmpty()){
            throw new NullPointerException(STATE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
        this.exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
