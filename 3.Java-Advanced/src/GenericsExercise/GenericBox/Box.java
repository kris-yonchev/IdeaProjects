package GenericsExercise.GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public void swap(int index1, int index2) {
        T temp = values.get(index1);
        values.set(index1, values.get(index2));
        values.set(index2, temp);
    }

    public double getGreater(T data) {
       return values.stream().filter(e -> e.compareTo(data) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        values.forEach(e -> {
            sb.append(String.format("%s: %s\n", e.getClass().getName(), e.toString()));
        });
        return sb.toString();
    }
}
