package IteratorAndComparatorExercise.StackIterator;

import java.util.*;
import java.util.function.Consumer;

public class Stack implements Iterable<String> {
    private List<String> list;


    public Stack() {
        this.list = new ArrayList<>();
    }

    public void push(String e) {
        this.list.add(e);
    }

    public void pop() {
        if (list.size() < 1) {
            throw new IllegalStateException("No elements");
        } else {
            String element = list.get(list.size() - 1);
            this.list.remove(element);
        }
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = list.size() - 1;

            @Override
            public boolean hasNext() {
                return index > 0;
            }

            @Override
            public String next() {
                String element = list.get(index);
                index--;
                return element;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        Collections.reverse(list);
        this.list.forEach(action::accept);
        this.list.forEach(action::accept);
    }
}
