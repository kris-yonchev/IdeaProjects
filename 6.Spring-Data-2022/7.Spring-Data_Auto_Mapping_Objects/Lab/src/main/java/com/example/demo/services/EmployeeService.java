package com.example.demo.services;

import com.example.demo.models.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findById(Integer id);

    void save(Employee employee);

    List<Employee> findAllEmployees();

    List<Employee> findEmployeeByYearBefore1990();
}
