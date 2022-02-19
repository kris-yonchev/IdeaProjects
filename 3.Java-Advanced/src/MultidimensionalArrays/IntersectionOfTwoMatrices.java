package MultidimensionalArrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        char[][] matrixOne = readMatrix(rows, columns, scanner);
        char[][] matrixTwo = readMatrix(rows, columns, scanner);

        char[][] outputMatrix = getOutputMatrix(matrixOne, matrixTwo);

        for (int row = 0; row < rows; row++) {
            for (int cols = 0; cols < columns; cols++) {
                System.out.print(outputMatrix[row][cols] + " ");
            }
            System.out.println();
        }

    }

    private static char[][] getOutputMatrix(char[][] matrixOne, char[][] matrixTwo) {
        for (int rows = 0; rows < matrixOne.length; rows++) {
            for (int columns = 0; columns < matrixOne[rows].length; columns++) {
                char filler = matrixOne[rows][columns] == matrixTwo[rows][columns]
                        ? matrixOne[rows][columns] : '*';
                matrixOne[rows][columns] = filler;
            }
        }

        return matrixOne;
    }

    public static char[][] readMatrix(int rows, int columns, Scanner scanner) {
        char[][] matrix = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine();
            String[] elements = line.split("\\s+");
            for (int i = 0; i < elements.length; i++) {
                char current = elements[i].charAt(0);
                matrix[row][i] = current;
            }

        }
        return matrix;
    }
}
