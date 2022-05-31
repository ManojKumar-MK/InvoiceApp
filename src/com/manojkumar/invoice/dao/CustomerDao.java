package com.manojkumar.invoice.dao;

import com.manojkumar.invoice.db.DBSource;
import com.manojkumar.invoice.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    private ArrayList<Customer> customers = DBSource.getCustomers();

    {
        customers.add(new Customer("MK","9944893647","manoj.akm7@gmail.com"));
        customers.add(new Customer("Guru","7812712821","david@gmail.com"));
        customers.add(new Customer("Viswa","9892191213","viswa@gmail.com"));
    }

    public void add(Customer customer)
    {
        customers.add(customer);
        System.out.println("Customer Added Successfully");

    }
    public boolean isExist(String mail)
    {
        for (Customer c: customers) {
            if(c.getEmail().equals(mail))
                return true;
        }
        return false;
    }

    public List<Customer> getAll()
    {
        return customers;
    }

    public boolean isExist(int customerId) {
        for (Customer c: customers
             ) {
                if(c.getId() == customerId)
                    return true;
        }

        return false;
    }

    public Customer getCustomer(int id) {
        Customer result = null;
        for (Customer c: customers) {
            if(c.getId() == id)
            {
                result = c;
            }

        }

        return result;

    }
}
