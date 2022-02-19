package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixSize = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixSize[0];
        int cols = matrixSize[1];
        int[][] matrix = new int[rows][cols];
        makeMatrix(matrix, scanner);


        for (int c = cols - 1; c >= 0; c--) {
            int row = rows-1;
            System.out.print(matrix[row][c] + " ");
            int a = row;
            int b = c;
            while (isValidIndex(matrix, --a, ++b)) {
                System.out.print(matrix[a][b] + " ");

            }
            System.out.println();
        }

        for (int r = rows - 2; r >= 0; r--) {
            int col = 0;
            System.out.print(matrix[r][col] + " ");
            int a = r;
            int b = col;
            while (isValidIndex(matrix, --a, ++b)) {
                System.out.print(matrix[a][b] + " ");
            }
            System.out.println();
        }

    }

    private static boolean isValidIndex(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void makeMatrix(int[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = arr;
        }
    }
}
