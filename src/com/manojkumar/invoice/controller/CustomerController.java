package com.manojkumar.invoice.controller;

import com.manojkumar.invoice.dao.CustomerDao;
import com.manojkumar.invoice.model.Customer;
import com.manojkumar.invoice.model.Invoice;
import com.manojkumar.invoice.utils.Constant;

import java.util.List;
import java.util.Scanner;

public class CustomerController {
    private static Scanner sc = new Scanner(System.in);
    private static CustomerDao customerDao;

    static {
        customerDao = new CustomerDao();
    }
    public static void addCustomer()
    {
        System.out.println("Enter the name :");
        String name = sc.nextLine();

        System.out.println("Enter the Phone Number : ");
        String phone = sc.nextLine();

        System.out.println("Enter the Email :");
        String email = sc.nextLine();

        if(!isExist(email)) // Then You add
        {
            Customer c = new Customer(name,phone,email);
            customerDao.add(c);

        }
        else
        {
            System.out.println("Already customer exist with given mail.");

        }


    }

    public static boolean isExist(String mail)
    {
        return customerDao.isExist(mail);
    }

    public static boolean isExist()
    {

        System.out.println("Enter the Customer Id");
        int id = sc.nextInt(); // if
        return customerDao.isExist(id);
    }

    public static void listCustomer()
    {
        List<Customer> customerList = customerDao.getAll();

        System.out.printf("******* %10s *******\n", Constant.COMPANY_NAME);
        System.out.println();
        if(customerList.isEmpty())
            System.out.println("No Customer Added");
        else
        {

            System.out.printf("%2s | %10s | %12s | %20s | %5s | %5s","ID","NAME","PNUMBER","EMAIL","S.COUNT","S.AMOUNT");
            System.out.println();
            for (Customer c : customerList) {

                System.out.printf("%2d | %10s | %12s | %20s | %5d | %.2f",c.getId(),c.getName(),c.getPhoneNumber(),c.getEmail(),c.getTotalSalesCount(),c.getTotalSalesAmount());
                System.out.println();
            }
        }
    }

    public static Customer getCustomer() {
        System.out.println("Enter the Customer Id");
        int id = sc.nextInt(); // if
        return customerDao.getCustomer(id);
    }

    public static void addInvoice(Customer c, Invoice invoice) {
        c.addInvoice(invoice);
    }
}
