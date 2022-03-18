package com.example.demo.entities.user;

import com.example.demo.entities.product.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private Integer age;

    @ManyToMany
    private List<User> friends;

    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
    private List<Product> productsSold;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.EAGER)
    private List<Product> productsBought;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<Product> getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(List<Product> productsSold) {
        this.productsSold = productsSold;
    }

    public List<Product> getProductsBought() {
        return productsBought;
    }

    public void setProductsBought(List<Product> productsBought) {
        this.productsBought = productsBought;
    }
}
