package com.example.demo.repositories;

import com.example.demo.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u " +
            "where(select count(p) from Product p where p.seller.id=u.id)>0" +
            " order by  u.lastName, u.firstName")
    List<User> findAllByCountOfSalesMoreThanOne();

    @Query("SELECT u from User u " +
            "where u.productsSold.size>0 " +
            "order by u.productsSold.size desc, u.lastName")
    List<User> findAllUsersWithMoreThanOneSoldProductsOrderBySoldProducts();

    @Query("SELECT u FROM User u" +
            " WHERE u.productsSold.size > 0" +
            " ORDER BY u.lastName, u.firstName")
    List<User> findUserWithMoreThanOneSoldProductOrderBySoldProduct();

    @Query("SELECT u FROM User u" +
            " WHERE u.productsSold.size > 0" +
            " ORDER BY u.productsSold.size DESC, u.lastName ASC")
    List<User> getUserWithAtLeastOneProductSold();
}
