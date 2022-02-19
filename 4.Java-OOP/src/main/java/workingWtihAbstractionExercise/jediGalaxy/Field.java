package workingWtihAbstractionExercise.jediGalaxy;

public class Field {
    private int[][] matrix;

    public Field(int rows, int cols) {
        this(rows, cols, 0);

    }

    public Field(int rows, int cols, int value) {
        this.matrix = new int[rows][cols];
        this.fillMatrix(value);
    }


    private void fillMatrix(int value) {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                this.matrix[i][j] = value++;
            }
        }
    }

    public boolean isInSide(int row, int col) {
        return row >= 0 && col >= 0 && row < this.matrix.length && col < this.matrix[row].length;
    }

    public void setValue(int row, int col, int newValue) {
        this.matrix[row][col] = newValue;
    }

    public int getValue(int row, int col) {
        return this.matrix[row][col];
    }

    public int getColLength(int row) {
        return this.matrix[row].length;
    }

}
