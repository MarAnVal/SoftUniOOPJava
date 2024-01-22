package BarracksWarsTheCommandsStrikeBack.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface UnitFactory {

    BarracksWarsTheCommandsStrikeBack.interfaces.Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException;
}