package IteratorAndComparatorExercise.ListyIterator;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int currentIndex;

    public ListyIterator(String... list) {
        this.list = List.of(list);
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < list.size() - 1;
    }

    public boolean move() {
        if (hasNext()) {
            this.currentIndex++;
            return true;
        }
        return false;
    }

    public void print() {
        if (this.list.size() == 0) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(this.list.get(currentIndex));
    }

    public void printAll() {
        this.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index;

            @Override
            public boolean hasNext() {
                return this.index < list.size();
            }

            @Override
            public String next() {
                String element = list.get(index);
                index++;
                return element;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        this.list.forEach(action::accept);
    }
}
