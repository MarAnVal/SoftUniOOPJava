package BarracksWarsANewFactory;

import BarracksWarsANewFactory.interfaces.Repository;
import BarracksWarsANewFactory.interfaces.Runnable;
import BarracksWarsANewFactory.interfaces.UnitFactory;
import BarracksWarsANewFactory.core.Engine;
import BarracksWarsANewFactory.core.factories.UnitFactoryImpl;
import BarracksWarsANewFactory.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
