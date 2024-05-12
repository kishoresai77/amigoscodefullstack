package com.fullstack.customer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jdbc")
public class CustomerJDBCDataAccessService implements CustomerDao {
    private final JdbcTemplate jdbcTemplate;
    private final CustomerRowMapper customerRowMapper;

    public CustomerJDBCDataAccessService(JdbcTemplate jdbcTemplate, CustomerRowMapper customerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerRowMapper = customerRowMapper;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        var sql = """
                SELECT  id,name,email,age
                FROM customer
                """;
        return jdbcTemplate.query(sql, customerRowMapper);
    }

    @Override
    public Optional selectById(Long id) {
        var sql = """
                SELECT  id,name,email,age
                FROM customer where id= ?
                """;
        return jdbcTemplate.query(sql, customerRowMapper, id).stream().findFirst();

    }

    @Override
    public void insertCustomer(Customer customer) {
        var sql = """
                INSERT INTO customer(name,email,age)
                VALUES(?,?,?)
                """;
        int result = jdbcTemplate.update(sql,
                customer.getName(),
                customer.getEmail(),
                customer.getAge()
        );
        System.out.println("jbdcTemplate= " + result);

    }

    @Override
    public boolean existCustomerByEmail(String email) {
        var sql = """
                SELECT  count(id)
                FROM customer where email= ?
                """;
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return count != null && count > 0;
    }

    @Override
    public void deleteCustomer(Long id) {
        var sql = """
                DELETE  
                FROM customer where id= ?
                """;
        Integer result = jdbcTemplate.update(sql, id);
        System.out.println("deleted customer by id result: " + result);

    }

    @Override
    public boolean existsCustomerById(Long id) {
        var sql = """
                SELECT  count(id)
                FROM customer where id= ?
                """;
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;

    }

    @Override
    public void updateCustomer(Customer update) {
        if (update.getName() != null) {
            String sql = """
                       UPDATE customer SET name=? where id=?
                    """;
            int result = jdbcTemplate.update(sql,
                    update.getName(),
                    update.getId()
            );
            System.out.println("update customer name result: " + result);
        }
        if (update.getAge() != 0) {
            String sql = """
                       UPDATE customer SET age=? where id=?
                    """;
            int result = jdbcTemplate.update(sql,
                    update.getAge(),
                    update.getId()
            );
            System.out.println("update customer age result: " + result);
        }
        if (update.getEmail() != null) {
            String sql = """
                       UPDATE customer SET email=? where id=?
                    """;
            int result = jdbcTemplate.update(sql,
                    update.getEmail(),
                    update.getId()
            );
            System.out.println("update customer name result: " + result);
        }


    }
}
