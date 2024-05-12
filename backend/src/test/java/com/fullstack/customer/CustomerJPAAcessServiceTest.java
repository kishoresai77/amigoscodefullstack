package com.fullstack.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class CustomerJPAAcessServiceTest {
    private CustomerJPAAcessService undertest;
    private AutoCloseable autoCloseable;
    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        undertest = new CustomerJPAAcessService(customerRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void selectAllCustomer() {
        undertest.selectAllCustomer();
        Mockito.verify(customerRepository).findAll();
    }

    @Test
    void selectById() {
        Long id = 1L;
        undertest.selectById(id);
        Mockito.verify(customerRepository).findById(id);
    }

    @Test
    void insertCustomer() {
        Customer customer = new Customer(
                1L, "John", "vallapu@", 33
        );
        undertest.insertCustomer(customer);
        Mockito.verify(customerRepository).save(customer);
    }

    @Test
    void existCustomerByEmail() {
        String email = "vallpu@";
        undertest.existCustomerByEmail(email);
        Mockito.verify(customerRepository).existsCustomerByEmail(email);
    }

    @Test
    void deleteCustomer() {
        Long id = 1L;
        undertest.deleteCustomer(id);
        Mockito.verify(customerRepository).deleteById(id);
    }

    @Test
    void existsCustomerById() {
        Long id = 1L;
        undertest.existsCustomerById(id);
        Mockito.verify(customerRepository).existsCustomerById(id);
    }

    @Test
    void updateCustomer() {
        Customer customer = new Customer(
                1l, "sai", "vallpu@3", 44
        );
        undertest.updateCustomer(customer);
        Mockito.verify(customerRepository).save(customer);

    }
}