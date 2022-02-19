package Exercises5;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int cakevolume = width * length;
        String command = scanner.nextLine();
        while (cakevolume > 0) {
            if (command.equals("STOP")) {
                break;
            }
            int piece = Integer.parseInt(command);
            cakevolume -= piece;
            if (cakevolume <= 0) {
                break;
            }
            command = scanner.nextLine();

        }
        int diff = Math.abs(cakevolume);
        if (cakevolume > 0) {
            System.out.printf("%d pieces are left.", cakevolume);
        } else {
            System.out.printf("No more cake left! You need %d pieces more.", diff);
        }
    }
}
