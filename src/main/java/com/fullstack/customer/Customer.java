package com.fullstack.customer;

import java.util.Objects;

public class Customer {
    private int id;
    private String name;
    private String Email;
    private int age;

    public Customer(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        Email = email;
        this.age = age;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
