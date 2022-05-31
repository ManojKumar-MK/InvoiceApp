package com.manojkumar.invoice.db;

import com.manojkumar.invoice.model.Customer;
import com.manojkumar.invoice.model.Invoice;
import com.manojkumar.invoice.model.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBSource {
    private static ArrayList<Customer> customers = new ArrayList<>();

    private static ArrayList<Product> products = new ArrayList<>();

    private static ArrayList<Invoice> invoices = new ArrayList<Invoice>();

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(ArrayList<Customer> customers) {
        DBSource.customers = customers;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<Product> products) {
        DBSource.products = products;
    }

    public static ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public static void setInvoices(ArrayList<Invoice> invoices) {
        DBSource.invoices = invoices;
    }
}

