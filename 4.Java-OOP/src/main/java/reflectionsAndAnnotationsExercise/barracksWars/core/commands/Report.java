package reflectionsAndAnnotationsExercise.barracksWars.core.commands;

import reflectionsAndAnnotationsExercise.barracksWars.interfaces.Executable;
import reflectionsAndAnnotationsExercise.barracksWars.interfaces.Repository;

public class Report implements Executable {

    private Repository repository;

    public Report() {

    }

    public Report(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
