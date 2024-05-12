package com.fullstack.customer;

import com.fullstack.AbstractTestContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerRepositoryTest  extends AbstractTestContainer {
    @Autowired
    private CustomerRepository undertest;

    @BeforeEach
    void setUp() {
    }

    @Test
    void existsCustomerByEmail() {
        String email = faker.internet().safeEmailAddress() + "-" + UUID.randomUUID();
        Customer customer=new Customer(
                faker.name().fullName(),
                email,
                20
        );
        undertest.save(customer);

        boolean actual= undertest.existsCustomerByEmail(email);
        assertThat(actual).isTrue();
    }

    @Test
    void existsCustomerById() {
        String email = faker.internet().safeEmailAddress() + "-" + UUID.randomUUID();
        Customer customer=new Customer(
                faker.name().fullName(),
                email,
                20
        );
        undertest.save(customer);

        Long  id = undertest.findAll().
                stream().
                filter(c -> c.getEmail().equals(email)).
                map(Customer::getId).findFirst().
                orElseThrow();

        boolean actual = undertest.existsCustomerById(id);
        assertThat(actual).isTrue();
    }
    @Test
    void existsCustomerByEmailFailsWhenEmailNotPresent() {
        String email = faker.internet().safeEmailAddress() + "-" + UUID.randomUUID();

        boolean actual= undertest.existsCustomerByEmail(email);
        assertThat(actual).isFalse();
    }
    @Test
    void existsCustomerByIdFailsWhenIdNotPresent() {
        Long  id = (long) -1;

        boolean actual = undertest.existsCustomerById(id);
        assertThat(actual).isFalse();
    }

}