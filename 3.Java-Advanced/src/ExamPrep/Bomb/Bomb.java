package ExamPrep.Bomb;

import java.util.Scanner;

public class Bomb {
    static int bombsCount = 0;
    static int sapperRow;
    static int sapperCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] mineField = new char[size][size];
        String[] commands = scanner.nextLine().split(",");
        boolean hasEnded = false;
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            for (char s : line.toCharArray()) {
                if (s == 'B') {
                    bombsCount++;
                }
            }
            mineField[i] = line.toCharArray();
            if (line.contains("s")) {
                sapperRow = i;
                sapperCol = line.indexOf("s");
            }
        }

        for (String command : commands) {
            if (!hasEnded && bombsCount > 0) {
                switch (command) {
                    case "up":
                        if (!isAtEdge(mineField, sapperRow - 1, sapperCol)) {
                            sapperRow = sapperRow - 1;
                            if (moving(mineField, sapperRow, sapperCol)) {
                                hasEnded = true;
                            }
                        }
                        break;
                    case "down":
                        if (!isAtEdge(mineField, sapperRow + 1, sapperCol)) {
                            sapperRow = sapperRow + 1;
                            if (moving(mineField, sapperRow, sapperCol)) {
                                hasEnded = true;
                            }
                        }
                        break;
                    case "left":
                        if (!isAtEdge(mineField, sapperRow, sapperCol - 1)) {
                            sapperCol = sapperCol - 1;
                            if (moving(mineField, sapperRow, sapperCol)) {
                                hasEnded = true;
                            }

                        }
                        break;
                    case "right":
                        if (!isAtEdge(mineField, sapperRow, sapperCol + 1)) {
                            sapperCol = sapperCol + 1;
                            if (moving(mineField, sapperRow, sapperCol)) {
                                hasEnded = true;
                            }
                        }
                        break;
                }
            }
        }
        if (hasEnded) {
            System.out.println("END! " + bombsCount + " bombs left on the field");
        } else if (bombsCount <= 0) {
            System.out.println("Congratulations! You found all bombs!");
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombsCount, sapperRow, sapperCol);
        }
    }

    private static boolean moving(char[][] mineField, int sapperRow, int sapperCol) {
        if (mineField[sapperRow][sapperCol] == 'B') {
            bombsCount--;
            mineField[sapperRow][sapperCol] = '+';
            System.out.println("You found a bomb!");
        } else return mineField[sapperRow][sapperCol] == 'e';
        return false;
    }

    private static boolean isAtEdge(char[][] mineField, int row, int col) {
        return row < 0 || row >= mineField.length || col < 0 || col >= mineField.length;
    }
}
