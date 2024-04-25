package com.fullstack.customer;

import java.util.ArrayList;
import java.util.List;

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
}
