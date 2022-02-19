package MultidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        String[] command = scanner.nextLine().split("[()]");
        int rotation = Integer.parseInt(command[1]) % 360;
        int cols = 0;
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String word = input;
            words.add(word);
            if (word.length() > cols) {
                cols = word.length();
            }

            input = scanner.nextLine();
        }
        int rows = words.size();
        int columns = cols;
        char[][] matrix = new char[rows][columns];
        makeMatrix(matrix, words, rows, columns);
        angleMatrix(rotation, matrix, rows, columns);

    }

    private static void angleMatrix(int rotation, char[][] matrix, int rows, int columns) {
        if (rotation==90) {
            for (int c = 0; c < columns; c++) {
                for (int r = rows - 1; r >= 0; r--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }

        } else if (rotation==180) {
            for (int r = rows - 1; r >= 0; r--) {
                for (int c = columns - 1; c >= 0; c--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }

        } else if (rotation==270) {
            for (int c = columns - 1; c >= 0; c--) {
                for (int r = 0; r < rows; r++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }

        } else {
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[r].length; c++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }
    }

    private static void makeMatrix(char[][] matrix, List<String> words, int rows, int cols) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (c < words.get(r).length()) {
                    matrix[r][c] = words.get(r).charAt(c);
                } else {
                    matrix[r][c] = ' ';
                }
            }

        }

    }
}
