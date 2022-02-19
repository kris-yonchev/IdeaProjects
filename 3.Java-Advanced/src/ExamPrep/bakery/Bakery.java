package ExamPrep.bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    public String name;
    public int capacity;
    public List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public int getCount() {
        return this.employees.size();
    }

    public void add(Employee employee) {
        if (this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return employees.stream().max(Comparator.comparing(Employee::getAge)).get();
    }

    public Employee getEmployee(String name) {
        return employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:", this.name)).append(System.lineSeparator());
        for (int i = 0; i < this.employees.size(); i++) {
            if (i == this.employees.size() - 1) {
                sb.append(this.employees.get(i));
            } else {
                sb.append(this.employees.get(i)).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
