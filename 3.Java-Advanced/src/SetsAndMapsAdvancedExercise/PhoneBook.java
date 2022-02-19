package SetsAndMapsAdvancedExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> map = new HashMap<>();
        while (!input.equals("search")) {
            String[] nameAndNumber = input.split("-");
            String name = nameAndNumber[0];
            String number = nameAndNumber[1];
            map.put(name, number);

            input = scanner.nextLine();
        }
        String name = scanner.nextLine();
        while (!name.equals("stop")) {

            if (map.containsKey(name)) {
                System.out.printf("%s -> %s\n", name, map.get(name));

            } else {
                System.out.printf("Contact %s does not exist.\n", name);
            }


            name = scanner.nextLine();
        }
    }
}
