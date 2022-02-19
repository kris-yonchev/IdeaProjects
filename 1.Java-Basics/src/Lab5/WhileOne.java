package Lab5;

import java.util.Scanner;

public class WhileOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String name = scanner.nextLine();
            if (name.equals("Stop")) {
                break;
            }
            System.out.println(name);
        }
    }
}
