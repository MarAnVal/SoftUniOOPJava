package BarracksWarsTheCommandsStrikeBack;

import BarracksWarsTheCommandsStrikeBack.interfaces.Repository;
import BarracksWarsTheCommandsStrikeBack.interfaces.Runnable;
import BarracksWarsTheCommandsStrikeBack.interfaces.UnitFactory;
import BarracksWarsTheCommandsStrikeBack.core.Engine;
import BarracksWarsTheCommandsStrikeBack.core.factories.UnitFactoryImpl;
import BarracksWarsTheCommandsStrikeBack.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
