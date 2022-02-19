package interfaceAndAbstractionExercise.celebration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Birthable> birthables = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] info = input.split("\\s+");

            switch (info[0]) {
                case "Citizen":
                    String name = info[1];
                    int age = Integer.parseInt(info[2]);
                    String id = info[3];
                    String birthDate = info[4];
                    Citizen citizen = new Citizen(name, age, id, birthDate);
                    birthables.add(citizen);
                    break;
                case "Pet":
                    String petName = info[1];
                    String petBirthDate = info[2];
                    Pet pet = new Pet(petName, petBirthDate);
                    birthables.add(pet);
                    break;
                case "Robot":
                    String model = info[1];
                    String robotId = info[2];
                    Robot robot = new Robot(model, robotId);
                    break;
            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(year)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }

}
