package IteratorAndComparatorExercise.Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> list;

    public Lake(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    class Frog implements Iterator<Integer> {
        int index = 0;
        boolean doneWithEven = false;

        @Override
        public boolean hasNext() {
            return index < list.size();
        }

        @Override
        public Integer next() {
            int current = index;
            index += 2;
            if (index >= list.size() && !doneWithEven) {
                index = 1;
                doneWithEven = true;
            }
            return list.get(current);
        }
    }
}
