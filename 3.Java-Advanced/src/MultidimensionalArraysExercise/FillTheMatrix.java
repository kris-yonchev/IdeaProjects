package MultidimensionalArraysExercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] info = scanner.nextLine().split(", ");
        int matrixSize = Integer.parseInt(info[0]);
        String method = info[1];
        int[][] matrix = new int[matrixSize][matrixSize];
        if (method.equals("A")) {
            makeMatrixA(matrix);
        } else {
            makeMatrixB(matrix);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] makeMatrixB(int[][] matrix) {
        int count = 0;
        for (int c = 0; c < matrix.length; c++) {
            if (c % 2 != 0) {
                for (int r = matrix.length - 1; r >= 0; r--) {
                    matrix[r][c] = ++count;
                }
            } else {
                for (int r = 0; r < matrix.length; r++) {
                    matrix[r][c] = ++count;
                }
            }
        }

        return matrix;
    }

    private static int[][] makeMatrixA(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int c = 0; c < matrix.length; c++) {
                matrix[c][i] = ++count;
            }

        }
        return matrix;
    }


}
