package BarracksWarsReturnOfTheDependencies;

import BarracksWarsReturnOfTheDependencies.core.Engine;
import BarracksWarsReturnOfTheDependencies.core.commands.AddCommand;
import BarracksWarsReturnOfTheDependencies.core.commands.FightCommand;
import BarracksWarsReturnOfTheDependencies.core.commands.ReportCommand;
import BarracksWarsReturnOfTheDependencies.core.commands.RetireCommand;
import BarracksWarsReturnOfTheDependencies.core.factories.UnitFactoryImpl;
import BarracksWarsReturnOfTheDependencies.data.UnitRepository;
import BarracksWarsReturnOfTheDependencies.interfaces.Repository;
import BarracksWarsReturnOfTheDependencies.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Engine engine = new Engine(repository, unitFactory);
        engine.registerCommand(AddCommand.class);
        engine.registerCommand(ReportCommand.class);
        engine.registerCommand(FightCommand.class);
        engine.registerCommand(RetireCommand.class);
        engine.run();
    }
}
