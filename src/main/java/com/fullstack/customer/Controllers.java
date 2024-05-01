package com.fullstack.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class Controllers {
    private final CustomerService customerService;

    public Controllers(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping()
    public List<Customer> getAllCustomer(){
        return customerService.getAllcustomer();
    }
    @GetMapping("{id}")
    public Customer getcustomerByiId(@PathVariable("id") Integer id){
        return customerService.getCustomerById(id);
    }
    @PostMapping()
    public void registerCustomer(@RequestBody CustomerDto register){
        customerService.insertCustomer(register);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable("id") Integer id){
        customerService.deleteCustomer(id);
    }
}
