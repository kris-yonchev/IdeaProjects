package com.example.demo;

import com.example.demo.models.Employee;
import com.example.demo.models.dto.EmployeeDTO;
import com.example.demo.models.dto.ManagerDTO;
import com.example.demo.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class Main implements CommandLineRunner {

    private final EmployeeService employeeService;

    @Autowired
    public Main(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public void run(String... args) throws Exception {

        Employee managerGuy = new Employee("Pesho",
                "Shpeka",
                LocalDate.of(1749, 1, 1),
                new BigDecimal(20),
                "Shpek str.",
                null
        );

        Employee employeeOne = new Employee("Misho",
                "Mishov",
                LocalDate.of(1664, 1, 1),
                BigDecimal.TEN,
                "Pernik str.",
                managerGuy);

        Employee employeeTwo = new Employee("Stamat",
                "Mandrov",
                LocalDate.of(1549, 2, 2),
                BigDecimal.ONE,
                "Kozloduy str.",
                managerGuy);

        employeeService.save(managerGuy);
        employeeService.save(employeeOne);
        employeeService.save(employeeTwo);

        List<Employee> allEmployees = employeeService.findAllEmployees();
        ModelMapper mapper = new ModelMapper();
        TypeMap<Employee, ManagerDTO> employeeToManagerDTO = mapper.typeMap(Employee.class, ManagerDTO.class);
        TypeMap<Employee, EmployeeDTO> employeeToEmployeeDTO = mapper.typeMap(Employee.class, EmployeeDTO.class);

//        LabProblem2
////        allEmployees
////                .stream()
////                .map(e -> e.getManager() == null ? employeeToManagerDTO.map(e) : employeeToEmployeeDTO.map(e))
////                .forEach(System.out::println);


        List<Employee> employeesToPrint = employeeService.findEmployeeByYearBefore1990();
        employeesToPrint
                .stream()
                .filter(e -> e.getManager() != null)
                .map(employeeToEmployeeDTO::map)
                .forEach(e -> System.out.printf("%s %s %s - Manager: %s\n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getSalary(),
                        e.getManager().getLastName() == null ? "[no manager]" : e.getManager().getLastName()));

    }
}
