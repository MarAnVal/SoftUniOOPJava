package BarracksWarsReturnOfTheDependencies.core.commands;

import BarracksWarsReturnOfTheDependencies.interfaces.Repository;

@NamedCommand(commandName = "retire")
public class RetireCommand extends Command {
    Repository repository;

    public RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        this.repository.removeUnit(unitType);
        return unitType + " retired!";
    }
}
