package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        Validations.validateName(name);
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    //· If you receive a command to remove a missing player, print:
    // "Player {Player name} is not in {Team name} team."
    public void removePlayer(String playerName) {
        for (Player currentPlayer : players) {
            if (currentPlayer.getName().equals(playerName)) {
                this.players.remove(currentPlayer);
                return;
            }
        }
        throw new IllegalArgumentException("Player " + playerName +
                " is not in " + this.name + " team.");
    }

    public double getRating() {
        return players.stream().mapToDouble(Player::overallSkillLevel)
                .average().orElse(0);
    }
}
