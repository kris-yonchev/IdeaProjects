package IteratorAndComparatorExercise.ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int compareTo(Person person) {
        if (this.name.compareTo(person.getName()) == 0) {
            if (this.age == person.getAge()) {
                return this.city.compareTo(person.getCity());
            }
            return Integer.compare(this.age, person.getAge());
        }
        return this.name.compareTo(person.getName());
    }
}
