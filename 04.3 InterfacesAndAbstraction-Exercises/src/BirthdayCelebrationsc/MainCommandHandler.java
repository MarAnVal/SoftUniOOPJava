package BirthdayCelebrationsc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCommandHandler implements CommandHandler {
    private Scanner scanner;
    private String endCommand;
    private List<String> commands;
    private List<Birthable> birthables;

    public MainCommandHandler(String endCommand) {
        this.scanner = new Scanner(System.in);
        this.endCommand = endCommand;
        this.commands = new ArrayList<>();
        this.birthables = new ArrayList<>();
    }

    @Override
    public void readCommand() {
        String currentCommand = this.scanner.nextLine();
        while (!currentCommand.equals(this.endCommand)) {
            commands.add(currentCommand);
            currentCommand = this.scanner.nextLine();
        }
    }

    @Override
    public void processCommand() {
        for (String command : commands) {
            String[] parts = command.split("\\s+");
            switch (parts[0]) {
                case "Citizen":
                    Birthable citizen = new Citizen(parts[1], Integer.parseInt(parts[2])
                            , parts[3], parts[4]);
                    this.birthables.add(citizen);
                    break;
                case "Pet":
                    Birthable pet = new Pet(parts[1], parts[2]);
                    this.birthables.add(pet);
                    break;
            }
        }
    }

    @Override
    public void executeCommand() {
        String wantedBirthYear = this.scanner.nextLine();
        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(wantedBirthYear))
                System.out.println(birthable.getBirthDate());
        }
    }
}