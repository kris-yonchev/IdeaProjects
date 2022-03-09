package com.example.demo.repositories;

import com.example.demo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e" +
            " WHERE YEAR(e.birthday) < 1990" +
            " ORDER BY e.salary DESC")
    List<Employee> findEmployeeByYearBefore1990();
}
