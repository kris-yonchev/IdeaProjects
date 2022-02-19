package DefiningClassesExercise.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Person> people = new HashMap<>();

        while (!input.equals("End")) {
            String[] info = input.split("\\s+");
            String personName = info[0];
            people.putIfAbsent(personName, new Person(personName, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
            switch (info[1]) {
                case "company":
                    Company company = new Company(info[2], info[3], Double.parseDouble(info[4]));
                    people.get(personName).setCompany(company);
                    break;
                case "car":
                    Car car = new Car(info[2], Integer.parseInt(info[3]));
                    people.get(personName).setCar(car);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(info[2], info[3]);
                    people.get(personName).getPokemonList().add(pokemon);
                    break;
                case "parents":
                    Parents parents = new Parents(info[2], info[3]);
                    people.get(personName).getParentList().add(parents);
                    break;
                case "children":
                    Kids kids = new Kids(info[2], info[3]);
                    people.get(personName).getChildList().add(kids);
                    break;
            }

            input = scanner.nextLine();
        }
        String command = scanner.nextLine();
        people.get(command).printFormat();
    }
}
