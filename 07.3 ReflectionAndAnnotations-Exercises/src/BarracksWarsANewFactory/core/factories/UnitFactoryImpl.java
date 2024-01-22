package BarracksWarsANewFactory.core.factories;

import BarracksWarsANewFactory.interfaces.Unit;
import BarracksWarsANewFactory.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "BarracksWarsANewFactory.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
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
