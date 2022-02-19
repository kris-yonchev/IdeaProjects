package reflectionsAndAnnotationsExercise.barracksWars.core.commands;

import reflectionsAndAnnotationsExercise.barracksWars.interfaces.Executable;
import reflectionsAndAnnotationsExercise.barracksWars.interfaces.Repository;
import reflectionsAndAnnotationsExercise.barracksWars.interfaces.Unit;
import reflectionsAndAnnotationsExercise.barracksWars.interfaces.UnitFactory;


public class Add implements Executable {


    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    public Add() {

    }

    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public String execute() {
        String unitType = data[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
