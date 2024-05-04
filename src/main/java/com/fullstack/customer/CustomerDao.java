package com.fullstack.customer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface CustomerDao {
    List<Customer> selectAllCustomer();
    Optional<Customer> selectById(Long id);
    void insertCustomer(Customer customer);
    boolean existCustomerByEmail(String email);
    void deleteCustomer(Long  id);
    boolean existsCustomerById(Long id);
    void updateCustomer(Customer update);
}
