package FundamentalsExercise7;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> regList = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            String name = command[1];
            switch (command[0]) {
                case "register":
                    String id = command[2];
                    if (!regList.containsKey(name)) {
                        regList.put(name, id);
                        System.out.println(name + " registered " + id + " successfully");
                    } else {
                        System.out.println("ERROR: already registered with plate number " + regList.get(name));
                    }
                    break;
                case "unregister":
                    if (!regList.containsKey(name)) {
                        System.out.println("ERROR: user " + name + " not found");
                    } else {
                        regList.remove(name);
                        System.out.println(name + " unregistered successfully");
                    }
                    break;
            }
        }
        regList.forEach((key, value) -> System.out.printf("%s => %s\n", key, value));
    }
}
