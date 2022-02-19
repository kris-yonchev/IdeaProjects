package Exam;

import java.util.Scanner;

public class MouseCheese {
    static int pRow;
    static int pCol;
    static int cheese;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int r = 0; r < size; r++) {
            String line = scanner.nextLine();
            matrix[r] = line.toCharArray();

            if (line.contains("M")) {
                pRow = r;
                pCol = line.indexOf("M");
            }

        }
        matrix[pRow][pCol] = '-';
        boolean outOfBounds = false;


        String command = scanner.nextLine();
        while (!command.equals("end")) {

            switch (command) {
                case "up":
                    outOfBounds = isHeOut(matrix, pRow - 1, pCol);
                    if (!outOfBounds) {
                        pRow = pRow - 1;
                        if (matrix[pRow][pCol] == 'B') {
                            matrix[pRow][pCol] = '-';
                            pRow = pRow - 1;

                        }
                        if (matrix[pRow][pCol] == 'c') {
                            cheese++;
                            matrix[pRow][pCol] = '-';
                        }
                    }
                    break;
                case "down":
                    outOfBounds = isHeOut(matrix, pRow + 1, pCol);
                    if (!outOfBounds) {
                        pRow = pRow + 1;
                        if (matrix[pRow][pCol] == 'B') {
                            matrix[pRow][pCol] = '-';
                            pRow = pRow + 1;
                        }
                        if (matrix[pRow][pCol] == 'c') {
                            cheese++;
                            matrix[pRow][pCol] = '-';
                        }
                    }
                    break;
                case "left":
                    outOfBounds = isHeOut(matrix, pRow, pCol - 1);
                    if (!outOfBounds) {
                        pCol = pCol - 1;
                        if (matrix[pRow][pCol] == 'B') {
                            matrix[pRow][pCol] = '-';
                            pCol = pCol - 1;
                        }
                        if (matrix[pRow][pCol] == 'c') {
                            cheese++;
                            matrix[pRow][pCol] = '-';
                        }
                    }
                    break;
                case "right":
                    outOfBounds = isHeOut(matrix, pRow, pCol + 1);
                    if (!outOfBounds) {
                        pCol = pCol + 1;
                        if (matrix[pRow][pCol] == 'B') {
                            matrix[pRow][pCol] = '-';
                            pCol = pCol + 1;
                        }
                        if (matrix[pRow][pCol] == 'c') {
                            cheese++;
                            matrix[pRow][pCol] = '-';
                        }
                    }
                    break;
            }
            if (outOfBounds) {
                System.out.println("Where is the mouse?");
                break;
            }
            command = scanner.nextLine();
        }

        if (!outOfBounds) {
            matrix[pRow][pCol] = 'M';
        }
        if (cheese < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", 5 - cheese);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", cheese);
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }


    private static boolean isHeOut(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix.length;
    }
}

