package main.java.Exam_14_August_2022.Football.core;

import main.java.Exam_14_August_2022.Football.entities.field.ArtificialTurf;
import main.java.Exam_14_August_2022.Football.entities.field.Field;
import main.java.Exam_14_August_2022.Football.entities.field.NaturalGrass;
import main.java.Exam_14_August_2022.Football.entities.player.Men;
import main.java.Exam_14_August_2022.Football.entities.player.Player;
import main.java.Exam_14_August_2022.Football.entities.player.Women;
import main.java.Exam_14_August_2022.Football.entities.supplement.Liquid;
import main.java.Exam_14_August_2022.Football.entities.supplement.Powdered;
import main.java.Exam_14_August_2022.Football.entities.supplement.Supplement;
import main.java.Exam_14_August_2022.Football.repositories.SupplementRepository;
import main.java.Exam_14_August_2022.Football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static main.java.Exam_14_August_2022.Football.common.ConstantMessages.*;
import static main.java.Exam_14_August_2022.Football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    //supplement - SupplementRepository
    private SupplementRepository supplement;
    //fields - a collection of Field
    private List<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        //Adds a Field. Valid types are: "ArtificialTurf" and "NaturalGrass".
        Field field = null;
        switch (fieldType) {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                break;
            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                break;
            default:
                //If the Field type is invalid, you have to throw a NullPointerException
                // with the following message: "Invalid field type."
                throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        fields.add(field);
        //If the Field is added successfully, the method should return the following String:
        //"Successfully added {fieldType}."
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplementByType = null;
        //Creates a supplement of the given type and adds it to the SupplementRepository.
        // Valid types are "Powdered" and "Liquid". If the supplement type is invalid,
        switch (type) {
            case "Powdered":
                supplementByType = new Powdered();
                break;
            case "Liquid":
                supplementByType = new Liquid();
                break;
            default:
                // throw an IllegalArgumentException with a message:
                //"Invalid supplement type."
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        this.supplement.add(supplementByType);
        //The method should return the following String if the operation is successful:
        //"Successfully added {supplementType}."
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        //Adds the desired Supplement to the Field with the given name.
        Supplement supplementForField = this.supplement.findByType(supplementType);
        if (supplementForField == null) {
            //If there is no such supplement, you have to throw an IllegalArgumentException with the following message:
            //"There isn't a Supplement of type {supplementType}."
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }
        //You have to remove the Supplement from the SupplementRepository if the insert is successful.
        Field givenField = null;
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                givenField = field;
                break;
            }
        }
        givenField.addSupplement(supplementForField);
        this.supplement.remove(supplementForField);
        //If no exceptions are thrown return the String:
        //"Successfully added {supplementType} to {fieldName}."
        return String.format(String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName));
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Field givenField = null;
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                givenField = field;
                break;
            }
        }
        //Check if the player type is valid. Valid Player types are:
        // "Men", "Women". Adds the desired Player to the Field with the given name.
        boolean canPlay = true;
        Player player = null;
        switch (playerType) {
            case "Men":
                if (givenField.getClass().getSimpleName().equals("NaturalGrass")) {
                    player = new Men(playerName, nationality, strength);
                } else {
                    canPlay = false;
                }
                break;
            case "Women":
                if (givenField.getClass().getSimpleName().equals("ArtificialTurf")) {
                    player = new Women(playerName, nationality, strength);
                } else {
                    canPlay = false;
                }
                break;
            default:
                //If the Player type is invalid, you have to throw an IllegalArgumentException with the following message:
                //"Invalid player type." - if the Player type is invalid.
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        //If no errors are thrown, return one of the following strings:
        if (!canPlay) {
            //"The pavement of the terrain is not suitable." - if the Player cannot play in the Field
            return FIELD_NOT_SUITABLE;
        }
        givenField.addPlayer(player);
        //"Successfully added {playerType} to {fieldName}." - if the Player is added successfully in the Field
        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field givenField = null;
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                givenField = field;
                break;
            }
        }
        //Drag all Player in the Field with the given name.
        givenField.drag();
        int playersCountInField = givenField.getPlayers().size();
        //Returns a string with information about how many players were successfully dragged in the following format:
        //"Player drag: {dragCount}"
        return String.format(PLAYER_DRAG, playersCountInField);
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field givenField = null;
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                givenField = field;
                break;
            }
        }
        //Calculates the value of the Field with the given name.
        // It is calculated by the sum of all Players's strengths in the Field.
        int sum = 0;
        Collection<Player> players = givenField.getPlayers();
        for (Player player : players) {
            sum+= player.getStrength();
        }
        //Return a string in the following format:
        //"The strength of Field {fieldName} is {value}."
        return String.format(STRENGTH_FIELD, fieldName, sum);
    }

    @Override
    public String getStatistics() {
        //Returns information about each field. You can use the overridden .getInfo Field method.
        //"{fieldName} ({fieldType}):
        //Player: {playerName1} {playerName2} {playerName3} (…) / Player: none
        //Supplement: {supplementsCount}
        //Energy: {sumEnergy}
        //{fieldName} ({fieldType}):
        //Player: {playerName1} {playerName2} {playerName3} (…) / Player: none
        //Supplement: {supplementsCount}
        //Energy: {sumEnergy}
        // (…)"
        //Note: Use \n or System.lineSeparator() for a new line.
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < fields.size(); i++) {
            if(i < fields.size() - 1){
                text.append(fields.get(i).getInfo());
                text.append(System.lineSeparator());
            } else {
                text.append(fields.get(i).getInfo());
            }
        }
        return text.toString();
    }
}
