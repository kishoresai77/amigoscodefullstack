package com.fullstack.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
@Repository("list")
public class CustomerDataAcessService implements CustomerDao{

   static List<Customer> customers;
    static {
             customers = new ArrayList<Customer>();
             Customer sai = new Customer(1,"sai","vallapu@",33);
             customers.add(sai);
             Customer  kishore= new Customer(2,"kishore","reddy@",55);
             customers.add(kishore);
    }
    @Override
    public List<Customer> selectAllCustomer() {
        return customers;
    }

    @Override
    public Optional<Customer> selectById(Integer id) {
      return  customers.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @Override
    public void insertCustomer(Customer customer) {
        customers.add(customer);

    }

    @Override
    public boolean existCustomerByEmail(String email) {
        return customers.stream().anyMatch(c -> c.getEmail().equals(email));
    }

    @Override
    public void deleteCustomer(Integer id) {

    }

    @Override
    public boolean existsCustomerById(Integer id) {
        return false;
    }
}
