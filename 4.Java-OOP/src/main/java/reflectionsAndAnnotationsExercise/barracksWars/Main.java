package reflectionsAndAnnotationsExercise.barracksWars;

import reflectionsAndAnnotationsExercise.barracksWars.core.CommandInterpreterImpl;
import reflectionsAndAnnotationsExercise.barracksWars.interfaces.CommandInterpreter;
import reflectionsAndAnnotationsExercise.barracksWars.interfaces.Repository;
import reflectionsAndAnnotationsExercise.barracksWars.interfaces.Runnable;
import reflectionsAndAnnotationsExercise.barracksWars.interfaces.UnitFactory;
import reflectionsAndAnnotationsExercise.barracksWars.core.Engine;
import reflectionsAndAnnotationsExercise.barracksWars.core.factories.UnitFactoryImpl;
import reflectionsAndAnnotationsExercise.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);


        Runnable engine = new Engine((CommandInterpreterImpl) commandInterpreter);
        engine.run();
    }
}
