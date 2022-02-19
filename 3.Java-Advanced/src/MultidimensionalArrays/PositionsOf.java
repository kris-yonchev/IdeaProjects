package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixSize = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int matrixRows = matrixSize[0];
        int[][] matrix = new int[matrixRows][];
        for (int i = 0; i < matrixRows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        int numberToLookFor = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix[rows][cols] == numberToLookFor) {
                    isFound = true;
                    System.out.println(rows + " " + cols);
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }


}
