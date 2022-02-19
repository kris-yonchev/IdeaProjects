package IteratorAndComparatorExercise.StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Person> nameComp = new TreeSet<>(new NameComparator());
        TreeSet<Person> ageComp = new TreeSet<>(new AgeComparator());
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] info = line.split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            Person person = new Person(name, age);
            nameComp.add(person);
            ageComp.add(person);
        }

        for (Person person : nameComp) {
            System.out.println(person);
        }
        for (Person person : ageComp) {
            System.out.println(person);
        }

    }
}
