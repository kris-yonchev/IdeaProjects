package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String matrixSize = scanner.nextLine();
        int[][] matrix = getMatrix(matrixSize, scanner);
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(getSum(matrix));
    }

    private static int getSum(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int cols = 0; cols < matrix[row].length; cols++) {
                sum += matrix[row][cols];
            }
        }
        return sum;
    }

    private static int[][] getMatrix(String matrixSize, Scanner scanner) {
        String[] sizes = matrixSize.split(", ");
        int rows = Integer.parseInt(sizes[0]);
        int columns = Integer.parseInt(sizes[1]);
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;

        }
        return matrix;
    }
}
