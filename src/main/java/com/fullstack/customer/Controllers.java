package com.fullstack.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controllers {
    private final CustomerService customerService;

    public Controllers(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public List<Customer> getAllCustomer(){
        return customerService.getAllcustomer();
    }
    @GetMapping("/{id}")
    public Customer getcustomerByiId(@PathVariable("id") Integer id){
        return customerService.getCustomerById(id);
    }
}
