package FootballTeamGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Team> teamsByName = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] commandParts = command.split(";");
            String commandName = commandParts[0];
            switch (commandName) {
                case "Team":
                    handleAddTeam(commandParts[1], teamsByName);
                    break;
                case "Add":
                    //{TeamName};{PlayerName};{Endurance};{Sprint};{Dribble};{Passing};{Shooting}
                    handleAddPlayerInTeam(commandParts[1], commandParts[2], commandParts[3], commandParts[4], commandParts[5], commandParts[6], commandParts[7], teamsByName);
                    break;
                case "Remove":
                    handleRemovePlayer(commandParts[1], commandParts[2], teamsByName);
                    break;
                case "Rating":
                    handleRating(commandParts[1], teamsByName);
                    break;
            }
            command = scanner.nextLine();
        }

    }

    private static void handleRating(String teamName, Map<String, Team> teamsByName) {
        Team team = getTeam(teamName, teamsByName);
        if (team != null) {
            System.out.printf("%s - %d%n", teamName, Math.round(team.getRating()));
        }
    }

    private static void handleRemovePlayer(String teamName, String playerName, Map<String, Team> teamsByName) {
        Team team = getTeam(teamName, teamsByName);
        if (team != null) {
            try {
                team.removePlayer(playerName);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void handleAddPlayerInTeam(String teamName, String playerName, String endurance, String sprint, String dribble, String passing, String shooting, Map<String, Team> teamsByName) {
        Team team = getTeam(teamName, teamsByName);
        if (team != null) {
            Player player = null;
            try {
                player = new Player(playerName,
                        Integer.parseInt(endurance),
                        Integer.parseInt(sprint),
                        Integer.parseInt(dribble),
                        Integer.parseInt(passing),
                        Integer.parseInt(shooting)
                );
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (player != null) {
                team.addPlayer(player);
            }
        }
    }

    private static Team getTeam(String teamName, Map<String, Team> teamsByName) {
        Team team = teamsByName.get(teamName);
        if (team == null) {
            System.out.printf("Team %s does not exist.%n", teamName);
            return null;
        }
        return team;
    }

    private static void handleAddTeam(String teamName, Map<String, Team> teamsByName) {
        try {
            Team team = new Team(teamName);
            teamsByName.put(teamName, team);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
