package com.fullstack;

import com.fullstack.customer.Customer;
import com.fullstack.customer.CustomerRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Random;

@SpringBootApplication

public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
@Bean
    CommandLineRunner runner(CustomerRepository customerRepository){
        return args -> {
            Faker faker = new Faker();
            Random random= new Random();
            Customer customer = new Customer(
                    faker.name().fullName(),
                    faker.internet().safeEmailAddress(),
                    random.nextInt(16,99)
            );
            customerRepository.save(customer);
        };

    }
}

