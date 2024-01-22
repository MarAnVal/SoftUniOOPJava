package BarracksWarsReturnOfTheDependencies.core.commands;

import BarracksWarsReturnOfTheDependencies.interfaces.Executable;

public abstract class Command implements Executable {
    private String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return data;
    }
}
