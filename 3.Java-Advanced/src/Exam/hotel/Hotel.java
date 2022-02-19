package Exam.hotel;


import java.util.ArrayList;
import java.util.List;

public class Hotel {
    public String name;
    public int capacity;
    public List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public int getCount() {
        return this.roster.size();
    }

    public void add(Person person) {
        if (this.roster.size() < capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove (String name) {
       return roster.removeIf(e -> e.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        Person p = null;
        for (Person person : roster) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                p = person;
            }
        }
        return p;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:", this.name)).append(System.lineSeparator());
        for (int i = 0; i < this.roster.size(); i++) {
            if (i == this.roster.size() - 1) {
                sb.append(this.roster.get(i));
            } else {
                sb.append(this.roster.get(i)).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
