package BarracksWarsTheCommandsStrikeBack.core.commands;

import BarracksWarsTheCommandsStrikeBack.interfaces.Repository;
import BarracksWarsTheCommandsStrikeBack.interfaces.UnitFactory;

public class ReportCommand extends Command{
    public ReportCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return this.getRepository().getStatistics();
    }
}
