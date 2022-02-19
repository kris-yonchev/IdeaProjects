package inheritance.stackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;
    private int index = -1;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
        this.index++;
    }

    public String pop() {
        return this.data.remove(this.index--);
    }

    public String peek() {
        return this.data.get(this.index);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }


}
