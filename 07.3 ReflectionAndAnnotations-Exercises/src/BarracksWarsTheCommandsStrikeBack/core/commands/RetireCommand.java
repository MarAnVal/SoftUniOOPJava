package BarracksWarsTheCommandsStrikeBack.core.commands;

import BarracksWarsTheCommandsStrikeBack.interfaces.Repository;
import BarracksWarsTheCommandsStrikeBack.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class RetireCommand extends Command{
    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        try {
            getRepository().removeUnit(unitType);
            return unitType + " retired!";
        } catch (IllegalStateException e) {
            return e.getMessage();
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
    }
}
