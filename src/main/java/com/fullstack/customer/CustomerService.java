package com.fullstack.customer;

import com.fullstack.customer.exception.ResourceDuplicationexception;
import com.fullstack.customer.exception.ResourceNotFound;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public void insertCustomer(CustomerDto customerDto){
    if(customerDao.existCustomerByEmail(customerDto.getEmail())){
        throw new ResourceDuplicationexception("Customer with email [%s] already exists".formatted(customerDto.getEmail()));
    }
    Customer customer= new Customer(
            customerDto.getName(),
            customerDto.getEmail(),
            customerDto.getAge()
    );
    customerDao.insertCustomer(customer);

    }
    public void deleteCustomer(Integer id){
        if(!customerDao.existsCustomerById(id)){
            throw  new ResourceNotFound("Customer with id [%s] not found".formatted(id));
        }
        customerDao.deleteCustomer(id);
    }
}
