package reflectionsAndAnnotations;

import reflectionsAndAnnotations.annotations.Reflection;
import reflectionsAndAnnotations.annotations.Tracker;

public class main {
    public static void main(String[] args) {

        Class<Reflection> reflection = Reflection.class;
        Tracker.printMethodsByAuthor(reflection);
    }
}
