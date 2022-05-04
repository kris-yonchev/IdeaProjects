import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonCollectionSlowImpl implements PersonCollection {

    private List<Person> people;

    public PersonCollectionSlowImpl() {
        this.people = new ArrayList<>();
    }

    @Override
    public boolean add(String email, String name, int age, String town) {
        if (this.people.stream().anyMatch(p -> p.getEmail().equals(email))) {
            return false;
        }
        Person person = new Person(email, name, age, town);
        return this.people.add(person);


    }

    @Override
    public int getCount() {
        return this.people.size();
    }

    @Override
    public boolean delete(String email) {
        return people.removeIf(p -> p.getEmail().equals(email));
    }

    @Override
    public Person find(String email) {
        return people.stream().filter(p -> p.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public Iterable<Person> findAll(String emailDomain) {
        return people.stream().filter(p -> p.getEmail().endsWith("@" + emailDomain))
                .sorted(Comparator.comparing(Person::getEmail))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Person> findAll(String name, String town) {
        return people.stream().filter(p -> p.getName().equals(name) && p.getTown().equals(town))
                .sorted(Comparator.comparing(Person::getEmail))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Person> findAll(int startAge, int endAge) {
        return people.stream().filter(p -> p.getAge() >= startAge && p.getAge() <= endAge)
                .sorted(Comparator.comparingInt(Person::getAge)
                        .thenComparing(Person::getEmail))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Person> findAll(int startAge, int endAge, String town) {
        return people.stream()
                .filter(p -> p.getTown().equals(town) && p.getAge() >= startAge && p.getAge() <= endAge)
                .sorted(Comparator.comparingInt(Person::getAge).thenComparing(Person::getEmail))
                .collect(Collectors.toList());
    }
}
