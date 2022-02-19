package ExamPrep.Python;

import java.util.Scanner;

public class Python {
    static int length = 1;
    static int pRow;
    static int pCol;
    static int food;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(", ");
        char[][] matrix = new char[size][size];
        for (int r = 0; r < size; r++) {
            String row = scanner.nextLine().replaceAll(" ", "");
            matrix[r] = row.toCharArray();
            if (row.contains("s")) {
                pRow = r;
                pCol = row.indexOf("s");
            }
            for (char c : matrix[r]) {
                if (c == 'f') {
                    food++;
                }
            }
        }

        boolean isDead = false;

        for (String direction : directions) {
            if (food > 0 && !isDead) {
                switch (direction) {
                    case "up":
                        isDead = moveSnake(matrix, pRow - 1, pCol);
                        break;
                    case "down":
                        isDead = moveSnake(matrix, pRow + 1, pCol);
                        break;
                    case "left":
                        isDead = moveSnake(matrix, pRow, pCol - 1);
                        break;
                    case "right":
                        isDead = moveSnake(matrix, pRow, pCol + 1);
                        break;
                }
            }
        }
        if (isDead) {
            System.out.println("You lose! Killed by an enemy!");
        } else if (food <= 0) {
            System.out.println("You win! Final python length is " + length);
        } else {
            System.out.println("You lose! There is still " + food + " food to be eaten.");
        }


    }

    private static boolean moveSnake(char[][] matrix, int newR, int newC) {
        if (isAtEdge(matrix, newR, newC)) {
            int[] newIndexes = flipSides(matrix.length, newR, newC);
            newR = newIndexes[0];
            newC = newIndexes[1];
        }
        pRow = newR;
        pCol = newC;

        if (matrix[newR][newC] == 'f') {
            food--;
            length++;
        } else return matrix[newR][newC] == 'e';

        return false;
    }

    private static int[] flipSides(int length, int r, int c) {
        int[] arr = new int[2];
        if (r < 0) {
            arr[0] = length - 1;
            arr[1] = c;
        } else if (r >= length) {
            arr[1] = c;
        } else if (c < 0) {
            arr[0] = r;
            arr[1] = length - 1;
        } else {
            arr[0] = r;
        }
        return arr;
    }


    private static boolean isAtEdge(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix.length;
    }
}
