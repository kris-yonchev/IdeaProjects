package reflectionsAndAnnotationsExercise.barracksWars.core.commands;

import reflectionsAndAnnotationsExercise.barracksWars.interfaces.Executable;

public class Fight implements Executable {


    public Fight() {

    }

    @Override
    public String execute() {
        return "fight";
    }
}
