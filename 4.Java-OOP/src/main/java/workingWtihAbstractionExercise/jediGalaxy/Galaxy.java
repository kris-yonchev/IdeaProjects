package workingWtihAbstractionExercise.jediGalaxy;

public class Galaxy {
    private Field field;

    public Galaxy(Field field) {
        this.field = field;
    }

    public void moveEvil(int row, int col) {
        while (row >= 0 && col >= 0) {
            if (this.field.isInSide(row, col)) {
                this.field.setValue(row, col, 0);
            }
            row--;
            col--;
        }
    }

    public long moveJedi(int row, int col) {
        long collectedStars = 0;
        while (row >= 0 && col < field.getColLength(0)) {
            if (this.field.isInSide(row, col)) {
                collectedStars += this.field.getValue(row, col);
            }

            col++;
            row--;
        }
        return collectedStars;
    }
}
