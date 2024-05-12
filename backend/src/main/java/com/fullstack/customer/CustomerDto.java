package com.fullstack.customer;

public class CustomerDto {
    String name;
    String Email;
    int age;

    public CustomerDto(String name, String email, int age) {
        this.name = name;
        Email = email;
        this.age = age;
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
}
