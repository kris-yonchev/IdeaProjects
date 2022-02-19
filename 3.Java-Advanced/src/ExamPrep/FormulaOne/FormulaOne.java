package ExamPrep.FormulaOne;

import java.util.Scanner;

public class FormulaOne {
    static int pRow;
    static int pCol;
    static int prevR;
    static int prevC;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int r = 0; r < size; r++) {
            String line = scanner.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("P")) {
                pRow = r;
                pCol = line.indexOf("P");
            }
        }
        matrix[pRow][pCol] = '.';
        boolean hasWon = false;
        for (int i = 0; i < commandsCount; i++) {
            prevR = pRow;
            prevC = pCol;
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    pRow = isAtEdge(matrix, pRow - 1);
                    if (matrix[pRow][pCol] == 'B') {
                        pRow = isAtEdge(matrix, pRow - 1);
                    }
                    break;
                case "down":
                    pRow = isAtEdge(matrix, pRow + 1);
                    if (matrix[pRow][pCol] == 'B') {
                        pRow = isAtEdge(matrix, pRow + 1);
                    }
                    break;
                case "left":
                    pCol = isAtEdge(matrix, pCol - 1);
                    if (matrix[pRow][pCol] == 'B') {
                        pCol = isAtEdge(matrix, pCol - 1);
                    }
                    break;
                case "right":
                    pCol = isAtEdge(matrix, pCol + 1);
                    if (matrix[pRow][pCol] == 'B') {
                        pCol = isAtEdge(matrix, pCol + 1);
                    }
                    break;
            }

            if (matrix[pRow][pCol] == 'T') {
                pRow = prevR;
                pCol = prevC;
            } else {
                if (matrix[pRow][pCol] == 'F') {
                    hasWon = true;

                }
            }
        }


        if (hasWon) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        matrix[pRow][pCol] = 'P';


        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static int isAtEdge(char[][] matrix, int index) {
        if (index < 0) {
            return matrix.length - 1;
        } else if (index >= matrix.length) {
            return 0;
        }
        return index;
    }
}
