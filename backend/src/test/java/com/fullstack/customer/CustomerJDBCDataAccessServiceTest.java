package com.fullstack.customer;

import com.fullstack.AbstractTestContainer;
import org.assertj.core.api.AbstractOptionalAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;
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
      String email=  faker.internet().safeEmailAddress()+"-"+ UUID.randomUUID();

        Customer customer=new Customer(
        faker.name().fullName(),
                email,
                20
        );
        undertest.insertCustomer(customer);

        List<Customer> customers= undertest.selectAllCustomer();

        assertThat(customers).isNotEmpty();

    }
    @Test
    void willReturnEmptyWhenSelectCustomerById() {
        Long id= (long) -1;
         Optional<Customer>select = undertest.selectById(id);
         assertThat(select).isEmpty();
    }

    @Test
    void selectById() {
        String email = faker.internet().safeEmailAddress() + "-" + UUID.randomUUID();
        Customer customer=new Customer(
                faker.name().fullName(),
                email,
                20
        );
        undertest.insertCustomer(customer);
        Long  id = undertest.selectAllCustomer().
                stream().
                filter(c -> c.getEmail().equals(email)).
                map(Customer::getId).findFirst().
                orElseThrow();

        Optional <Customer> actual  = undertest.selectById(id);

        assertThat(actual).isPresent().hasValueSatisfying(c -> {
                    assertThat(c.getId()).isEqualTo(id);
                    assertThat(c.getName()).isEqualTo(customer.getName());
                    assertThat(c.getEmail()).isEqualTo(customer.getEmail());
                    assertThat(c.getAge()).isEqualTo(customer.getAge());

                }
        );


    }

    @Test
    void insertCustomer() {
    }

    @Test
    void existCustomerByEmail() {
        String email = faker.internet().safeEmailAddress() + "-" + UUID.randomUUID();
        Customer customer=new Customer(
                faker.name().fullName(),
                email,
                20
        );
        undertest.insertCustomer(customer);

    boolean actual= undertest.existCustomerByEmail(email);
    assertThat(actual).isTrue();
    }

    @Test
    void existCustomerWithEmailReturnFalseWhenDoesNotExists() {
        String email = faker.internet().safeEmailAddress() + "-" + UUID.randomUUID();

         boolean  actual =undertest.existCustomerByEmail(email);
         assertThat(actual).isFalse();


    }

    @Test
    void deleteCustomer() {
        String email = faker.internet().safeEmailAddress() + "-" + UUID.randomUUID();
        Customer customer=new Customer(
                faker.name().fullName(),
                email,
                20
        );
        undertest.insertCustomer(customer);
        Long  id = undertest.selectAllCustomer().
                stream().
                filter(c -> c.getEmail().equals(email)).
                map(Customer::getId).findFirst().
                orElseThrow();
        undertest.deleteCustomer(id);

        Optional select = undertest.selectById(id);
        assertThat(select).isNotPresent();
    }

    @Test
    void existsCustomerById() {
        String email = faker.internet().safeEmailAddress() + "-" + UUID.randomUUID();
        Customer customer=new Customer(
                faker.name().fullName(),
                email,
                20
        );
        undertest.insertCustomer(customer);
        Long  id = undertest.selectAllCustomer().
                stream().
                filter(c -> c.getEmail().equals(email)).
                map(Customer::getId).findFirst().
                orElseThrow();
        boolean actual = undertest.existsCustomerById(id);
        assertThat(actual).isTrue();
    }

    @Test
    void existCustomerWithIdWillReturnFalseWhenIdNotPresent() {
        Long  id= (long) -1;
        boolean actual = undertest.existsCustomerById(id);
        assertThat(actual).isFalse();
    }

    @Test
    void updateCustomerEmail() {
        String email = faker.internet().safeEmailAddress() + "-" + UUID.randomUUID();
        Customer customer=new Customer(
                faker.name().fullName(),
                email,
                20
        );
        undertest.insertCustomer(customer);
        Long  id = undertest.selectAllCustomer().
                stream().
                filter(c -> c.getEmail().equals(email)).
                map(Customer::getId).findFirst().
                orElseThrow();

        String newemail = faker.internet().safeEmailAddress() + "-" + UUID.randomUUID();
        Customer update= new Customer();
        update.setId(id);
        update.setEmail(newemail);
        undertest.updateCustomer(update);
       Optional<Customer> actual =  undertest.selectById(id);
         assertThat(actual).isPresent().hasValueSatisfying(c -> {
             assertThat(c.getId()).isEqualTo(id);
             assertThat(c.getEmail()).isEqualTo(newemail);
             assertThat(c.getName()).isEqualTo(customer.getName());
             assertThat(c.getAge()).isEqualTo(customer.getAge());
         });



    }

    @Test
    void updateCustomerName() {
        String email = faker.internet().safeEmailAddress() + "-" + UUID.randomUUID();
        Customer customer=new Customer(
                faker.name().fullName(),
                email,
                20
        );
        undertest.insertCustomer(customer);
        Long  id = undertest.selectAllCustomer().
                stream().
                filter(c -> c.getEmail().equals(email)).
                map(Customer::getId).findFirst().
                orElseThrow();

        var newname="foo";
        Customer update= new Customer();
        update.setId(id);
        update.setName(newname);
       undertest.updateCustomer(update);
          Optional<Customer> actual=undertest.selectById(id);
          assertThat(actual).isPresent().hasValueSatisfying(c -> {

              assertThat(c.getId()).isEqualTo(id);
              assertThat(c.getName()).isEqualTo(newname);
              assertThat(c.getEmail()).isEqualTo(customer.getEmail());
              assertThat(c.getAge()).isEqualTo(customer.getAge());

          });

    }

    @Test
    void updateCustomerage() {
        String email = faker.internet().safeEmailAddress() + "-" + UUID.randomUUID();
        Customer customer=new Customer(
                faker.name().fullName(),
                email,
                20
        );
        undertest.insertCustomer(customer);
        Long  id = undertest.selectAllCustomer().
                stream().
                filter(c -> c.getEmail().equals(email)).
                map(Customer::getId).findFirst().
                orElseThrow();

        var newage= 33;
        Customer update= new Customer();
        update.setId(id);
        update.setAge(newage);

        undertest.updateCustomer(update);
          Optional<Customer> actual=undertest.selectById(id);
            assertThat(actual).isPresent().hasValueSatisfying(c -> {
                assertThat(c.getId()).isEqualTo(id);
                assertThat(c.getAge()).isEqualTo(newage);
                assertThat(c.getEmail()).isEqualTo(customer.getEmail());
                assertThat(c.getName()).isEqualTo(customer.getName());
            });
    }

    @Test
    void updateAllProperties() {
        String email = faker.internet().safeEmailAddress() + "-" + UUID.randomUUID();
        Customer customer=new Customer(
                faker.name().fullName(),
                email,
                20
        );
        undertest.insertCustomer(customer);
        Long  id = undertest.selectAllCustomer().
                stream().
                filter(c -> c.getEmail().equals(email)).
                map(Customer::getId).findFirst().
                orElseThrow();

        var newage=34;
        String newemail = faker.internet().safeEmailAddress() + "-" + UUID.randomUUID();
        var newname="foo";


        Customer update= new Customer();
        update.setId(id);
        update.setAge(newage);
        update.setName(newname);
        update.setEmail(newemail);

        undertest.updateCustomer(update);
       Optional<Customer> actual =  undertest.selectById(id);
        assertThat(actual).isPresent().hasValue(update);
    }

    @Test
    void willNotUpdateWhenNothingToUpdate() {
        String email = faker.internet().safeEmailAddress() + "-" + UUID.randomUUID();
        Customer customer=new Customer(
                faker.name().fullName(),
                email,
                20
        );
        undertest.insertCustomer(customer);
        Long  id = undertest.selectAllCustomer().
                stream().
                filter(c -> c.getEmail().equals(email)).
                map(Customer::getId).findFirst().
                orElseThrow();

        Customer update= new Customer();
        update.setId(id);
        undertest.updateCustomer(update);

        Optional<Customer> actual=undertest.selectById(id);
        assertThat(actual).isPresent().hasValueSatisfying(c -> {
            assertThat(c.getId()).isEqualTo(id);
            assertThat(c.getAge()).isEqualTo(customer.getAge());
            assertThat(c.getEmail()).isEqualTo(customer.getEmail());
            assertThat(c.getName()).isEqualTo(customer.getName());


        });
}
}
