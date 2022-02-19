package reflectionsAndAnnotations.gettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> reflection = Reflection.class;

        Arrays.stream(reflection.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("get") && m.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(m.getName() + " will return class " + m.getReturnType().getName()));

        Arrays.stream(reflection.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("set") && m.getParameterCount() == 1)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(m.getName() + " and will set field of class " + m.getParameterTypes()[0].getName()));


    }
}
