package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = makeMatrix(rows, scanner);
        String[] wrongValueInput = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(wrongValueInput[0]);
        int col = Integer.parseInt(wrongValueInput[1]);
        int wrongValue = matrix[row][col];
        int[][] newMatrix = new int[rows][matrix[0].length];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] != wrongValue) {
                    newMatrix[r][c] = matrix[r][c];
                } else {
                    if (isValidIndex(matrix, r - 1, c)) {
                        if (matrix[r - 1][c] != wrongValue) {
                            newMatrix[r][c] += matrix[r - 1][c];
                        }
                    }
                    if (isValidIndex(matrix, r + 1, c)) {
                        if (matrix[r + 1][c] != wrongValue) {
                            newMatrix[r][c] += matrix[r + 1][c];
                        }
                    }
                    if (isValidIndex(matrix, r, c + 1)) {
                        if (matrix[r][c + 1] != wrongValue) {
                            newMatrix[r][c] += matrix[r][c + 1];
                        }
                    }
                    if (isValidIndex(matrix, r, c - 1)) {
                        if (matrix[r][c - 1] != wrongValue) {
                            newMatrix[r][c] += matrix[r][c - 1];
                        }
                    }


                }
            }
        }
        printMatrix(newMatrix);

    }

    private static void printMatrix(int[][] newMatrix) {
        for (int r = 0; r < newMatrix.length; r++) {
            for (int c = 0; c < newMatrix[r].length; c++) {
                System.out.print(newMatrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidIndex(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }


    private static int[][] makeMatrix(int rows, Scanner scanner) {
        int[][] matrix = new int[rows][];
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        }
        return matrix;
    }
}
