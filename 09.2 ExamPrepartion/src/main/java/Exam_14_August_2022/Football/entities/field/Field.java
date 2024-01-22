package main.java.Exam_14_August_2022.Football.entities.field;

import main.java.Exam_14_August_2022.Football.entities.player.Player;
import main.java.Exam_14_August_2022.Football.entities.supplement.Supplement;

import java.util.Collection;

public interface Field {
    int sumEnergy();

    void addPlayer(Player player);

    void removePlayer(Player player);

    void addSupplement(Supplement supplement);

    void drag();

    String getInfo();

    Collection<Player> getPlayers();

    Collection<Supplement> getSupplements();

    String getName();
}
