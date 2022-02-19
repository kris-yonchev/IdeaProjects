package ExamPrep.ReVolt;

import java.util.Scanner;

public class ReVolt {
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
            if (line.contains("f")) {
                pRow = r;
                pCol = line.indexOf("f");
            }
        }
        matrix[pRow][pCol] = '-';
        boolean hasWon = false;
        String command = scanner.nextLine();
        for (int i = 1; i <= commandsCount; i++) {
            prevR = pRow;
            prevC = pCol;
            Character word;
            switch (command) {
                case "up":
                    pRow--;
                    if (pRow < 0) {
                        pRow = matrix.length - 1;
                    }
                    break;
                case "down":
                    pRow++;
                    if (pRow >= matrix.length) {
                        pRow = 0;
                    }
                    break;
                case "left":
                    pCol--;
                    if (pCol < 0) {
                        pCol = matrix.length - 1;
                    }
                    break;
                case "right":
                    pCol++;
                    if (pCol >= matrix.length) {
                        pCol = 0;
                    }
                    break;
            }
            word = matrix[pRow][pCol];
            if (word.equals('F')) {
                hasWon = true;
                break;
            } else if (word.equals('B')) {
                commandsCount++;
                continue;
            } else if (word.equals('T')) {
                pCol = prevC;
                pRow = prevR;
                word = matrix[pRow][pCol];
            }
            if (i == commandsCount) {
                break;
            }
            command = scanner.nextLine();

        }
        if (hasWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        matrix[pRow][pCol] = 'f';
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
