package polymorphismExercise.calculator;

import java.util.ArrayDeque;

public class MemoryRecall implements Operation {
    private ArrayDeque<Integer> memory;

    public MemoryRecall(ArrayDeque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {

    }

    @Override
    public int getResult() {
        return memory.pop();
    }

    @Override
    public boolean isCompleted() {
        return !this.memory.isEmpty();
    }
}
