package BarracksWarsReturnOfTheDependencies.core.commands;

import BarracksWarsReturnOfTheDependencies.interfaces.Repository;
import BarracksWarsReturnOfTheDependencies.interfaces.Unit;
import BarracksWarsReturnOfTheDependencies.interfaces.UnitFactory;
@NamedCommand(commandName = "add")
public class AddCommand extends Command {
    Repository repository;
    UnitFactory unitFactory;
    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
