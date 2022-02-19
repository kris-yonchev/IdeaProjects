package GenericsExercise.CustomList;

public class Sorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {
        for (int i = 0; i < customList.size(); i++) {
            T element = customList.get(i);
            for (int j = i + 1; j < customList.size(); j++) {
                T nextOne = customList.get(j);
                if (element.compareTo(nextOne) > 0) {
                    customList.swap(i, j);
                }
            }
        }
    }
}
