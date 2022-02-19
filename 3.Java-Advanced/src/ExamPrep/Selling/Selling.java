package ExamPrep.Selling;

import java.util.Scanner;

public class Selling {
    static int pRow;
    static int pCol;
    static int cash;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int moneyNeeded = 50;
        char[][] matrix = new char[size][size];
        for (int r = 0; r < size; r++) {
            String line = scanner.nextLine();
            matrix[r] = line.toCharArray();

            if (line.contains("S")) {
                pRow = r;
                pCol = line.indexOf("S");
            }

        }
        matrix[pRow][pCol] = '-';
        boolean outOfBounds = false;

        while (!outOfBounds && cash < moneyNeeded) {

            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    outOfBounds = isHeIn(matrix, pRow - 1, pCol);
                    if (!outOfBounds) {
                        moves(matrix, pRow - 1, pCol);
                    }
                    break;
                case "down":
                    outOfBounds = isHeIn(matrix, pRow + 1, pCol);
                    if (!outOfBounds) {
                        moves(matrix, pRow + 1, pCol);
                    }
                    break;
                case "left":
                    outOfBounds = isHeIn(matrix, pRow, pCol - 1);
                    if (!outOfBounds) {
                        moves(matrix, pRow, pCol - 1);
                    }
                    break;
                case "right":
                    outOfBounds = isHeIn(matrix, pRow, pCol + 1);
                    if (!outOfBounds) {
                        moves(matrix, pRow, pCol + 1);
                    }
                    break;
            }
        }

        if (outOfBounds) {
            System.out.println("Bad news, you are out of the bakery.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
            matrix[pRow][pCol] = 'S';
        }
        System.out.println("Money: " + cash);
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void moves(char[][] matrix, int row, int col) {
        if (matrix[row][col] == 'O') {
            matrix[row][col] = '-';
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[r].length; c++) {
                    if (matrix[r][c] == 'O') {
                        matrix[r][c] = '-';
                        row = r;
                        col = c;
                    }
                }
            }
        } else if (matrix[row][col] != '-') {
            cash += Integer.parseInt(String.valueOf(matrix[row][col]));
            matrix[row][col] = '-';
        }
        pRow = row;
        pCol = col;
    }

    private static boolean isHeIn(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix.length;
    }
}
