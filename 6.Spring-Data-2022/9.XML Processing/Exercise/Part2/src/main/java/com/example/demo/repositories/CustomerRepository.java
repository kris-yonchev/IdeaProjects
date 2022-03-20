package com.example.demo.repositories;

import com.example.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select c.name, count(s.id) as carsBought, sum(p.price) as total\n" +
            "from customers as c\n" +
            "join sales s on c.id = s.customer_id\n" +
            "join cars_parts cp on s.car_id = cp.car_id\n" +
            "join parts p on p.id = cp.parts_id\n" +
            "group by c.id\n" +
            "having carsBought > 0\n" +
            "order by total desc, carsBought desc;", nativeQuery = true)
    List<String> getAllBySaleListBiggerThanOne();

    @Query("SELECT c FROM Customer c" +
            " ORDER BY c.birthDate ASC, c.isYoungDriver ASC")
    List<Customer> getCustomerInfo();

}
