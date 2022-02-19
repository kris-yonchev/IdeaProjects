package encapsulation.validationData;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String firstName = data[0];
            String lastName = data[1];
            int age = Integer.parseInt(data[2]);
            double salary = Double.parseDouble(data[3]);
            try {
                Person person = new Person(firstName, lastName, age, salary);
                people.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        double bonus = Double.parseDouble(scanner.nextLine());

        DecimalFormat format = new DecimalFormat("#.0##");
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.printf("%s %s gets %s leva\n", person.getFirstName(), person.getLastName(), format.format(person.getSalary()));
        }
    }
}
