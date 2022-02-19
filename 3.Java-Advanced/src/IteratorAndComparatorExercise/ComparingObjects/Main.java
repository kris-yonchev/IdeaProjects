package IteratorAndComparatorExercise.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        while (!input.equals("END")) {
            String[] info = input.split(" ");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            String city = info[2];

            Person person = new Person(name, age, city);
            people.add(person);


            input = scanner.nextLine();
        }

        int compare = Integer.parseInt(scanner.nextLine());
        Person personToCompare = people.remove(compare - 1);

        int same = 0;
        int diff = 0;

        for (Person person : people) {
            if (person.compareTo(personToCompare) == 0) {
                same++;
            } else {
                diff++;
            }
        }
        if (same == 0) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", ++same, diff, people.size() + 1);
        }
    }
}
