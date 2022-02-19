package MultidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CrossFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];

        List<List<Integer>> matrix = new ArrayList<>();
        int count = 1;
        for (int r = 0; r < rows; r++) {
            matrix.add(new ArrayList<>());
            for (int c = 0; c < cols; c++) {
                matrix.get(r).add(count++);
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] data = input.split("\\s+");

            int row = Integer.parseInt(data[0]);
            int col = Integer.parseInt(data[1]);
            int radius = Integer.parseInt(data[2]);

            for (int i = row - radius; i <= row + radius; i++) {
                if (isInRange(i, col, matrix) && i != row) {
                    matrix.get(i).remove(col);
                }
            }

            for (int i = col + radius; i >= col - radius; i--) {
                if (isInRange(row, i, matrix)) {
                    matrix.get(row).remove(i);
                }
            }

            matrix.removeIf(List::isEmpty);

            input = scanner.nextLine();
        }
        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInRange(int i, int col, List<List<Integer>> matrix) {
        return i >= 0 && i < matrix.size() && col >= 0 && col < matrix.get(i).size();
    }
}
