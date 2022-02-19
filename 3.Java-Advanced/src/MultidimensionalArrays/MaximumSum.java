package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine().split(", ")[0]);


        int[][] matrix = getMatrix(rows, scanner, ", ");

        int[][] maxMatrix = new int[2][2];
        int best = 0;
        for (int r = 0; r < matrix.length-1; r++) {
            for (int c = 0; c < matrix[r].length-1; c++) {
                int sum = matrix[r][c] + matrix[r][c + 1] + matrix[r + 1][c] + matrix[r + 1][c + 1];
                if (sum > best) {
                    best = sum;
                    maxMatrix = new int[][]{
                            {matrix[r][c], matrix[r][c + 1]},
                            {matrix[r + 1][c], matrix[r + 1][c + 1]}
                    };
                }
            }
        }
        printMatrix(maxMatrix);
        System.out.println(best);
    }


    private static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getMatrix(int rows, Scanner scanner, String separator) {
        int[][] matrix = new int[rows][];
        for (int r = 0; r < matrix.length; r++) {

            matrix[r] = Arrays.stream(scanner.nextLine()
                    .split(separator))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }
        return matrix;
    }
}
