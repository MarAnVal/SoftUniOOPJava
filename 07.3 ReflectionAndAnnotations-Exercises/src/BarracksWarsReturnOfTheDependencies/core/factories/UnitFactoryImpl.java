package BarracksWarsReturnOfTheDependencies.core.factories;

import BarracksWarsReturnOfTheDependencies.interfaces.Unit;
import BarracksWarsReturnOfTheDependencies.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        try {
            Class<?> unitTypeClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<?> constructor = unitTypeClass.getConstructor();
            return (Unit) constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException |
                 InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }
}
