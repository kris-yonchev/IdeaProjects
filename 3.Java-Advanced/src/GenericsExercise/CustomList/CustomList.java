package GenericsExercise.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public T remove(int index) {
        return elements.remove(index);
    }

    public boolean contains(T element) {
        return elements.contains(element);
    }

    public void swap(int index1, int index2) {
        Collections.swap(elements, index1, index2);
    }

    public int countGreaterThan(T element) {
        return (int) elements.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return elements.stream().max(Comparable::compareTo).get();
    }

    public T getMin() {
        return elements.stream().min(Comparable::compareTo).get();
    }

    public int size() {
        return elements.size();
    }

    public T get(int index) {
        return elements.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : this.elements) {
            sb.append(element).append("\n");
        }
        return sb.toString();
    }


}
