package ExamPrep.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    public List<Employee> employees;
    public String name;
    public int capacity;

    public Cafe(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public int getCount() {
        return employees.size();
    }

    public void addEmployee(Employee employee) {
        if (capacity > employees.size()) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (Employee e : employees) {
            if (e.getName().equals(name)) {
                employees.remove(e);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        int oldAge = Integer.MIN_VALUE;
        Employee oldest = null;
        for (Employee e : employees) {
            if (e.getAge() > oldAge) {
                oldAge = e.getAge();
                oldest = e;
            }
        }
        return oldest;
    }

    public Employee getEmployee(String name) {
        for (Employee e : employees) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Cafe ").append(this.name).append(":").append("\n");
        for (Employee e : employees) {
            sb.append(e).append("\n");
        }
        return sb.toString();
    }
}
