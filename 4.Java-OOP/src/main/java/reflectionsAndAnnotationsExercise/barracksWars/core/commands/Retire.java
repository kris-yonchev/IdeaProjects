package reflectionsAndAnnotationsExercise.barracksWars.core.commands;

import reflectionsAndAnnotationsExercise.barracksWars.interfaces.Executable;
import reflectionsAndAnnotationsExercise.barracksWars.interfaces.Repository;

public class Retire implements Executable {

    private String[] data;
    private Repository repository;

    public Retire() {

    }

    public Retire(String[] data, Repository repository) {
        this.data = data;
        this.repository = repository;

    }

    @Override
    public String execute() {
        String unitType = data[1];
        this.repository.removeUnit(unitType);
        return unitType + " retired!";
    }
}
