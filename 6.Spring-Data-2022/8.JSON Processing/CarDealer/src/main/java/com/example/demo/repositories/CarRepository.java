package com.example.demo.repositories;

import com.example.demo.entities.Car;
import com.example.demo.entities.dto.q2.CarFromMakeDto;
import com.example.demo.entities.dto.q4.CarModelMakeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT c FROM Car c" +
            " WHERE c.make = 'Toyota'" +
            " ORDER BY c.model, c.travelledDistance DESC")
    List<Car> findAllCarFromMake();

}
