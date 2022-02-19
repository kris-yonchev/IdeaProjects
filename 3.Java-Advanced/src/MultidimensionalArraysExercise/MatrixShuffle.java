package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = arr[0];
        int cols = arr[1];
        String[][] matrix = new String[rows][cols];
        makeMatrix(matrix, scanner);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] command = input.split("\\s+");
            if (isValid(command, matrix)) {
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }
            input = scanner.nextLine();
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(String[] command, String[][] matrix) {
        if (!command[0].equals("swap")) {
            return false;
        }
        if (command.length != 5) {
            return false;
        }
        int row1 = Integer.parseInt(command[1]);
        int col1 = Integer.parseInt(command[2]);
        int row2 = Integer.parseInt(command[3]);
        int col2 = Integer.parseInt(command[4]);
        if (row1 < 0 || row1 > matrix.length || col1 < 0 || col1 > matrix.length
                && row2 < 0 || row2 > matrix.length || col2 < 0 || col2 > matrix.length) {
            return false;
        }
        String temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
        return true;

    }

    private static void makeMatrix(String[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = scanner.nextLine().split("\\s+");
        }
    }
}
