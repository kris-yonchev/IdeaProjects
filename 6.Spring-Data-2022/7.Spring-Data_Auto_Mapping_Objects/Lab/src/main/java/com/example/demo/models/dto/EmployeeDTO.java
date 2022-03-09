package com.example.demo.models.dto;

import com.example.demo.models.Employee;

import java.math.BigDecimal;

public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private Employee manager;

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("\t- %s %s: %.2f", firstName, lastName, salary);
    }
}
