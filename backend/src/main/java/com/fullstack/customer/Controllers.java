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
    public Customer getcustomerByiId(@PathVariable("id") Long  id){
        return customerService.getCustomerById(id);
    }
    @PostMapping()
    public void registerCustomer(@RequestBody CustomerDto register){
        customerService.insertCustomer(register);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable("id") Long  id){
        customerService.deleteCustomer(id);
    }
    @PutMapping("{id}")
    public void  updateCustomer(@PathVariable("id") Long  id , @RequestBody CustomerUpdateRequest customerUpdate){
   customerService.updateCustomer(id,customerUpdate);


    }
}
