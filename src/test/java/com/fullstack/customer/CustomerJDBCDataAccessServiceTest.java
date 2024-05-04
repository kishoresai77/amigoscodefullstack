package com.fullstack.customer;

import com.fullstack.AbstractTestContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


class CustomerJDBCDataAccessServiceTest  extends AbstractTestContainer {
    private CustomerJDBCDataAccessService undertest;
    private final CustomerRowMapper customerRowMapper=new CustomerRowMapper();
    @BeforeEach
    void setUp() {
        undertest=new CustomerJDBCDataAccessService(
                getJdbcTemplate(),
                customerRowMapper
        );
    }

    @Test
    void selectAllCustomer() {
        Customer customer=new Customer(
        faker.name().fullName(),
        faker.internet().safeEmailAddress()+"-"+ UUID.randomUUID(),
                20
        );
        undertest.insertCustomer(customer);

        List<Customer> customers= undertest.selectAllCustomer();

        assertThat(customers).isNotEmpty();

    }

    @Test
    void selectById() {
    }

    @Test
    void insertCustomer() {
    }

    @Test
    void existCustomerByEmail() {
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void existsCustomerById() {
    }

    @Test
    void updateCustomer() {
    }
}