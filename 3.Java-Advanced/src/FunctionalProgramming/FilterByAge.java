package FunctionalProgramming;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Supplier<Person> personCreator = () -> {
            String[] info = scanner.nextLine().split(", ");
            return new Person(info[0], Integer.parseInt(info[1]));
        };

        List<Person> people = IntStream.range(0, n)
                .mapToObj(ignored -> personCreator.get())
                .collect(Collectors.toList());

        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String[] format = scanner.nextLine().split("\\s+");

        var filter = getFilteredPerson(condition, ageLimit);
        var printer = getPrinter(format);

        people
                .stream()
                .filter(filter)
                .forEach(printer);


    }

    private static Predicate<Person> getFilteredPerson(String condition, int age) {
        return condition.equals("older")
                ? p -> p.age >= age
                : p -> p.age <= age;
    }

    private static Consumer<Person> getPrinter(String[] format) {
        if (format.length > 1) {
            return p -> System.out.printf("%s - %d\n", p.name, p.age);
        } else if (format[0].equals("name")) {
            return p -> System.out.printf("%s\n", p.name);
        } else {
            return p -> System.out.printf("%d\n", p.age);
        }
    }

    private static class Person {
        private final String name;
        private final int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
