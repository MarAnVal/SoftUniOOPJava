package main.java.Exam_14_August_2022.Football.entities.field;

import main.java.Exam_14_August_2022.Football.entities.player.Player;
import main.java.Exam_14_August_2022.Football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static main.java.Exam_14_August_2022.Football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static main.java.Exam_14_August_2022.Football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {
    //name - String
    private String name;

    //capacity -  int
    private int capacity;

    //supplements - Collection<Supplement>
    private Collection<Supplement> supplements;
    //players - Collection<Player>
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    @Override
    public int sumEnergy() {
        //??
        int sum = 0;
        for (Supplement supplement : this.supplements) {
            sum += supplement.getEnergy();
        }
        return sum;
    }

    @Override
    public void addPlayer(Player player) {
        //If there is not enough capacity to add the Player in the
        // Field throw an IllegalStateException with the following message:
        //"Not enough capacity."
        if (this.capacity == this.players.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void drag() {
        //The drag() method stimulated all players on the field.
        players.forEach(Player::stimulation);
    }

    @Override
    public String getInfo() {
        StringBuilder text = new StringBuilder();
        //"{fieldName} ({fieldType}):
        text.append(String.format("%s (%s):", this.getName(), this.getClass().getSimpleName()));
        text.append(System.lineSeparator());

        List<String> playersNames = new ArrayList<>();
        for (Player player : players) {
            playersNames.add(player.getName());
        }
        String playersByName = "none";
        if (!playersNames.isEmpty()){
            playersByName = String.join(" ", playersNames);
        }
        //Player: {playerName1} {playerName2} {playerName3} (…) / Player: none
        text.append(String.format("Player: %s", playersByName));
        text.append(System.lineSeparator());
        //Supplement: {supplementsCount}
        text.append(String.format("Supplement: %d", this.supplements.size()));
        text.append(System.lineSeparator());
        //Energy: {sumEnergy}"
        text.append(String.format("Energy: %d", this.sumEnergy()));
        return text.toString();
    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
