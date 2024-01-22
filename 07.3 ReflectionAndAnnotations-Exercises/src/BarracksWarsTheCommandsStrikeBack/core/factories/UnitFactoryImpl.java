package BarracksWarsTheCommandsStrikeBack.core.factories;

import BarracksWarsTheCommandsStrikeBack.interfaces.Unit;
import BarracksWarsTheCommandsStrikeBack.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "BarracksWarsTheCommandsStrikeBack.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        Class<?> unitTypeClass;
        try {
            unitTypeClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }

        Constructor<?> constructor;
        try {
            constructor = unitTypeClass.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }

        Object unit;
        try {
            unit = constructor.newInstance();
        } catch (InstantiationException |
                 IllegalAccessException |
                 InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
        return (Unit) unit;
    }
}
