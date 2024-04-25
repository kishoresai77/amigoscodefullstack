package com.fullstack.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controllers {



    @GetMapping
    public List<Customer> getAllCustomer(){
        return null;
    }
}
