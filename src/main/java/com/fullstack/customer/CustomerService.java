package com.fullstack.customer;

import com.fullstack.customer.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerService {
    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("jpa") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    public List<Customer> getAllcustomer(){
        return customerDao.selectAllCustomer();

    }
    public Customer getCustomerById(Integer id){
        return customerDao.selectById(id).orElseThrow( () -> new ResourceNotFound("customer with id [%s] not found ".formatted(id)));
    }
}
