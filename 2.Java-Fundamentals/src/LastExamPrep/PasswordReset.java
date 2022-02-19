package LastExamPrep;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] command = input.split("\\s+");

            switch (command[0]) {
                case "TakeOdd":
                    pass = getNewPass(pass);
                    System.out.println(pass);
                    break;
                case "Cut":
                    int index = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);
                    String substring = pass.substring(index, index + length);
                    pass = pass.replaceFirst(substring, "");
                    System.out.println(pass);

                    break;
                case "Substitute":
                    String substringToReplace = command[1];
                    String substitute = command[2];
                    if (pass.contains(substringToReplace)) {
                        pass = pass.replaceAll(substringToReplace, substitute);
                        System.out.println(pass);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            input = scanner.nextLine();

        }
        System.out.println("Your password is: " + pass);
    }

    private static String getNewPass(String pass) {
        String newPass = "";
        for (int i = 1; i < pass.length(); i += 2) {
            char symbol = pass.charAt(i);
            newPass += symbol;

        }
        return newPass;
    }
}
