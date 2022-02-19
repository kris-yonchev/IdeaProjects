package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDiff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        makeMatrix(matrix, scanner);
        System.out.println(Math.abs(getDiagonalOne(matrix) - getDiagonalTwo(matrix)));

    }

    private static int getDiagonalTwo(int[][] matrix) {
        int sum = 0;
        int row = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[row][i];
            row--;
        }
//        for (int r = 0; r < matrix.length; r++) {
//            for (int c = 0; c < matrix.length; c++) {
//                if (c==matrix.length-1-r) {
//                    sum+=matrix[r][c];
//                }
//            }
//        }
        return sum;
    }

    private static int getDiagonalOne(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }

        return sum;

    }

    private static void makeMatrix(int[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
