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
    public Optional<Customer> selectById(Long id) {
        return customerRepository.findById((long) Math.toIntExact(id));
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
    public void deleteCustomer(Long id) {
        customerRepository.deleteById((long) Math.toIntExact(id));
    }

    @Override
    public boolean existsCustomerById(Long id) {
        return customerRepository.existsCustomerById((long) Math.toIntExact(id));
    }

    @Override
    public void updateCustomer(Customer update) {
        customerRepository.save(update);
    }
}
