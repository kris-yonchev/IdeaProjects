package FundamentalsExercise6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<NameForOpinionPoll> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] personInfo = scanner.nextLine().split(" ");
            String personName = personInfo[0];
            int personAge = Integer.parseInt(personInfo[1]);
            NameForOpinionPoll person = new NameForOpinionPoll(personName, personAge);
            people.add(person);
        }
        List<NameForOpinionPoll> filteredList = people.stream().filter(e -> e.getAge() > 30).sorted(Comparator.comparing(NameForOpinionPoll::getName)).collect(Collectors.toList());
        for (NameForOpinionPoll nameForOpinionPoll : filteredList) {
            System.out.printf("%s - %d\n", nameForOpinionPoll.getName(), nameForOpinionPoll.getAge());
        }
    }

    public static class NameForOpinionPoll {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public NameForOpinionPoll(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
