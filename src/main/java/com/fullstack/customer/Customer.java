package com.fullstack.customer;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
public class Customer {
    @Id
    @SequenceGenerator(
            name="customer-id-sequence",
            sequenceName = "customer-id-sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer-id-sequence"
    )
    private   Integer id;
    @Column(
            nullable = false
    )
    private String name;
    @Column(
            nullable = false
    )
    private String Email;
    @Column(
            nullable = false
    )
    private int age;

    public Customer(Integer id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        Email = email;
        this.age = age;
    }

    public Customer() {
    }

    public Customer(String name, String email, int age) {
        this.name = name;
        Email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && age == customer.age && Objects.equals(name, customer.name) && Objects.equals(Email, customer.Email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, Email, age);
    }
}
