package reflectionsAndAnnotationsExercise.barracksWars.core;

import reflectionsAndAnnotationsExercise.barracksWars.interfaces.Executable;
import reflectionsAndAnnotationsExercise.barracksWars.interfaces.Repository;
import reflectionsAndAnnotationsExercise.barracksWars.interfaces.UnitFactory;
import reflectionsAndAnnotationsExercise.barracksWars.interfaces.CommandInterpreter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {

    private Repository repository;
    private UnitFactory unitFactory;

    private static String COMMANDS_PATH_NAME = "reflectionsAndAnnotationsExercise.barracksWars.core.commands.";

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {

        Executable executable = null;

        commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);

        try {
            Class<? extends Executable> clazz = (Class<? extends Executable>) Class.forName(COMMANDS_PATH_NAME + commandName);
            Constructor<? extends Executable> constructor = clazz.getDeclaredConstructor();

            executable = constructor.newInstance();

            injectFields(executable, data);

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
            e.printStackTrace();
        }


        return executable;
    }

    private void injectFields(Executable executable, String[] data) {
        Field[] declaredFields = executable.getClass().getDeclaredFields();
        try {
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                if (declaredField.getType() == String[].class) {
                    declaredField.set(executable, data);
                } else if (declaredField.getType() == Repository.class) {
                    declaredField.set(executable, this.repository);
                } else if (declaredField.getType() == UnitFactory.class) {
                    declaredField.set(executable, this.unitFactory);
                }

            }
        } catch (Exception ignored) {
        }
    }
}
