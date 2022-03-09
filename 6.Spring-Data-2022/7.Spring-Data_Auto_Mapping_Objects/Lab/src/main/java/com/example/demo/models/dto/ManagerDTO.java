package com.example.demo.models.dto;

import com.example.demo.models.Employee;

import java.util.List;

public class ManagerDTO {
    private String firstName;
    private String lastName;
    private List<Employee> employees;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return String.format("%s %s | Employees: %d", firstName, lastName, getEmployees().size());
    }
}
