package com.fullstack;

import com.fullstack.customer.Customer;
import com.fullstack.customer.CustomerRepository;
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

@SpringBootApplication

public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
//@Bean
//    CommandLineRunner runner(CustomerRepository customerRepository){
//        return args -> {
//            Customer sai = new Customer( "sai", "vallapu@", 33);
//            Customer kishore = new Customer( "kishore", "reddy@", 55);
//            List<Customer> customer = List.of(sai, kishore);
//            customerRepository.saveAll(customer);
//        };
//
//    }
}

