import entities.*;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problems {
    private final EntityManager em;
    private final Scanner scanner;

    public Problems(EntityManager em) {
        this.em = em;
        this.scanner = new Scanner(System.in);
    }

    public void changeCasing() {
        List<Town> towns = em.createQuery(
                "SELECT t FROM Town t" +
                        " WHERE LENGTH(t.name) <= 5", Town.class).getResultList();

        em.getTransaction().begin();
        towns.forEach(em::detach);

        for (Town town : towns) {
            town.setName(town.getName().toLowerCase());
        }

        towns.forEach(em::merge);
        em.flush();
        em.getTransaction().commit();

    }

    public void containsEmployee() {
        String fullName = scanner.nextLine();
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e " +
                "WHERE concat(e.firstName, ' ', e.lastName) = :name", Employee.class)
                .setParameter("name", fullName)
                .getResultList();

        System.out.println(employees.size() == 0 ? "NO" : "YES");
    }

    public void employeeWithSalaryOver50000() {
        em.createQuery("SELECT e FROM Employee e" +
                " WHERE e.salary > 50000", Employee.class)
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    public void employeeFromDepartment() {
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e " +
                "WHERE e.department.id = 6" +
                "ORDER BY e.salary, e.id", Employee.class).getResultList();
        for (Employee e : employees) {
            System.out.printf("%s %s from %s - $%.2f\n",
                    e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary());
        }
    }

    public void addNewAddressAndUpdate() {
        Address address = addAddress("Vitoshka 15");
        String lastName = scanner.nextLine();

        Employee employee = em.createQuery("SELECT e FROM Employee e " +
                "WHERE e.lastName = :name", Employee.class)
                .setParameter("name", lastName)
                .getSingleResult();

        em.getTransaction().begin();
        employee.setAddress(address);
        em.getTransaction().commit();
    }

    private Address addAddress(String addressText) {
        Address address = new Address();
        address.setText(addressText);
        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();
        return address;
    }

    public void addressWithEmployeeCount() {
        List<Address> addresses = em.createQuery(
                "SELECT a FROM Address a " +
                        " ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList();

        addresses.forEach(a -> System.out.printf("%s, %s - %d employees\n",
                a.getText(),
                a.getTown() == null ? "" : a.getTown().getName(),
                a.getEmployees().size())
        );
    }

    public void getEmployeeWithProject() {
        int id = Integer.parseInt(scanner.nextLine());
        Employee employee = em.find(Employee.class, id);
        System.out.printf("%s %s - %s\n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartment().getName());

        employee
                .getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.printf("\t%s\n", p.getName()));

    }

    public void findLatestProjects() {
        List<Project> projects = em.createQuery("SELECT p FROM Project p " +
                " ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList();

        projects
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.printf("Project name: %s\n\t" +
                                "Project Description: %s\n\t" +
                                "Project Start Date:%s\n\t" +
                                "Project End Date: %s\n",
                        p.getName(),
                        p.getDescription(),
                        p.getStartDate(),
                        p.getEndDate()));
    }

    public void increaseSalary() {
        em.getTransaction().begin();
        em.createQuery("UPDATE Employee e " +
                " SET e.salary = e.salary * 1.12" +
                " WHERE e.department.id IN (1, 2, 4, 11)")
                .executeUpdate();
        em.getTransaction().commit();

        em.createQuery("SELECT e FROM Employee e " +
                " WHERE e.department.id IN (1, 2, 4, 11)", Employee.class)
                .getResultList()
                .forEach(e -> System.out.printf("%s %s ($%.2f)\n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getSalary()));
    }

    public void findEmployeeByFirstName() {
        String pattern = scanner.nextLine();
        List<Employee> employees = em.createQuery(
                "SELECT e FROM Employee e " +
                        " WHERE e.firstName LIKE CONCAT(:name, '%')", Employee.class)
                .setParameter("name", pattern)
                .getResultList();
        employees.forEach(e -> System.out.printf("%s %s - %s - ($%.2f)\n",
                e.getFirstName(),
                e.getLastName(),
                e.getJobTitle(),
                e.getSalary()));
    }

    public void employeesMaximumSalaries() {
        List<Department> departments = em.createQuery("SELECT d FROM Department d " +
                " WHERE d.manager.salary NOT BETWEEN 30000 AND 70000" +
                " GROUP BY d.name", Department.class).getResultList();

        departments.forEach(d -> System.out.printf("%s %.2f\n",
                d.getName(),
                d.getManager().getSalary()));
    }

    public void removeTowns() {
        String townName = scanner.nextLine();
        Town townToDelete = em.createQuery("SELECT t Town t " +
                " WHERE t.name = :town", Town.class)
                .setParameter("town", townName)
                .getSingleResult();

        int townId = townToDelete.getId();
        em.getTransaction().begin();
        List<Integer> addressesIds = em.createQuery("SELECT a FROM Address a " +
                " WHERE a.town.id = :townId", Address.class)
                .setParameter("townId", townId)
                .getResultStream()
                .map(Address::getId)
                .collect(Collectors.toList());

        em.createQuery("UPDATE Employee e " +
                " SET e.address = NULL" +
                " WHERE e.address.id IN :addresses")
                .setParameter("addresses", addressesIds)
                .executeUpdate();

        int affectedAddresses = em.createQuery("DELETE FROM Address a " +
                " WHERE a.id IN :addresses")
                .setParameter("addresses", addressesIds)
                .executeUpdate();

        em.remove(townToDelete);
        em.getTransaction().commit();

        System.out.println(affectedAddresses <= 1 ?
                String.format("%d address in %s deleted", affectedAddresses, townName) :
                String.format("%d addresses in %s deleted", affectedAddresses, townName));
    }
}
