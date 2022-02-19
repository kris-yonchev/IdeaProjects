package FundamentalsExercise6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<OrderByAgeClass> people = new ArrayList<>();
        while (!input.equals("End")) {
            String[] personInfo = input.split("\\s+");
            String name = personInfo[0];
            String id = personInfo[1];
            int age = Integer.parseInt(personInfo[2]);
            OrderByAgeClass person = new OrderByAgeClass(name, id, age);
            people.add(person);
            input = scanner.nextLine();
        }
        people.sort(Comparator.comparing(OrderByAgeClass::getAge));
        for (OrderByAgeClass person : people) {
            System.out.printf("%s with ID: %s is %d years old.\n", person.getName(), person.getId(), person.getAge());
        }
    }

    public static class OrderByAgeClass {
        private String name;
        private String id;
        private int age;

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        public OrderByAgeClass(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

}
