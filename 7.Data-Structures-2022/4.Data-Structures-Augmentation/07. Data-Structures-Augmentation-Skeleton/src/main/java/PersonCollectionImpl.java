import java.util.*;
import java.util.stream.Collectors;

public class PersonCollectionImpl implements PersonCollection {

    private Set<Person> people;
    private Map<String, Person> byEmail;
    private Map<String, TreeSet<Person>> byDomains;
    private Map<String, Set<Person>> byNameAndTown;
    private Map<Integer, Set<Person>> byAge;

    public PersonCollectionImpl() {
        this.people = new TreeSet<>(Comparator.comparingInt(Person::getAge).thenComparing(Person::getEmail));
        this.byEmail = new HashMap<>();
        this.byNameAndTown = new HashMap<>();
        this.byAge = new HashMap<>();
        this.byDomains = new HashMap<>();
    }

    @Override
    public boolean add(String email, String name, int age, String town) {
        if (byEmail.containsKey(email)) {
            return false;
        }

        Person person = new Person(email, name, age, town);
        this.people.add(person);
        this.byAge.putIfAbsent(age, new TreeSet<>());
        this.byAge.get(age).add(person);
        byEmail.putIfAbsent(email, person);
        String nameAndTown = name + town;
        this.byNameAndTown.putIfAbsent(nameAndTown, new TreeSet<>());
        this.byNameAndTown.get(nameAndTown).add(person);
        String domain = getDomain(email);
        this.byDomains.putIfAbsent(domain, new TreeSet<>());
        this.byDomains.get(domain).add(person);
        return true;
    }

    @Override
    public int getCount() {
        return this.byEmail.size();
    }

    @Override
    public boolean delete(String email) {
        Person toDelete = byEmail.remove(email);
        if (toDelete == null) {
            return false;
        }

        this.people.remove(toDelete);
        byDomains.get(getDomain(toDelete.getEmail())).remove(toDelete);
        byNameAndTown.get(toDelete.getName() + toDelete.getTown()).remove(toDelete);
        byAge.get(toDelete.getAge()).remove(toDelete);
        return true;
    }

    @Override
    public Person find(String email) {
        return this.byEmail.get(email);
    }

    @Override
    public Iterable<Person> findAll(String emailDomain) {
        TreeSet<Person> people = this.byDomains.get(emailDomain);
        return people != null ? people : new TreeSet<>();
    }

    @Override
    public Iterable<Person> findAll(String name, String town) {
        Set<Person> people = this.byNameAndTown.get(name + town);
        return people != null ? people : new TreeSet<>();
    }

    @Override
    public Iterable<Person> findAll(int startAge, int endAge) {
        List<Person> found = new ArrayList<>();
        byAge.entrySet().stream().filter(k -> k.getKey() >= startAge && k.getKey() <= endAge)
                .forEach(k -> found.addAll(k.getValue()));
        return found;
    }

    @Override
    public Iterable<Person> findAll(int startAge, int endAge, String town) {
        List<Person> found = new ArrayList<>();
        byAge.entrySet().stream().filter(k -> k.getKey() >= startAge && k.getKey() <= endAge)
                .forEach(k -> found.addAll(k.getValue()));

        return found.stream().filter(p -> p.getTown().equals(town)).collect(Collectors.toList());
    }

    private String getDomain(String email) {
        return email.substring(email.indexOf("@") + 1);
    }
}
