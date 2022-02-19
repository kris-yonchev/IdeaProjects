package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int r = size[0];
        int c = size[1];
        int[][] matrix = new int[r][c];
        getMatrix(matrix, scanner);
        int max = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;
        for (int rows = 0; rows < matrix.length - 2; rows++) {
            for (int cols = 0; cols < matrix[0].length - 2; cols++) {
                int sum = 0;
                sum += matrix[rows][cols] + matrix[rows][cols + 1] + matrix[rows][cols + 2];
                sum += matrix[rows + 1][cols] + matrix[rows + 1][cols + 1] + matrix[rows + 1][cols + 2];
                sum += matrix[rows + 2][cols] + matrix[rows + 2][cols + 1] + matrix[rows + 2][cols + 2];
                if (sum > max) {
                    max = sum;
                    row = rows;
                    col = cols;
                }
            }
        }
        System.out.println("Sum = " + max);
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void getMatrix(int[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
