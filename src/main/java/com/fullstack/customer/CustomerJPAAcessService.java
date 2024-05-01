package com.fullstack.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("jpa")
public class CustomerJPAAcessService implements CustomerDao {
    private final CustomerRepository customerRepository;

    public CustomerJPAAcessService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> selectById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public boolean existCustomerByEmail(String email) {
       return customerRepository.existsCustomerByEmail(email);

    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public boolean existsCustomerById(Integer id) {
        return customerRepository.existsCustomerById(id);
    }
}
