package com.manojkumar.invoice.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Invoice {
    private static int invoiceCount = 1;
    private int id;
    private Customer customer;
    private LocalDateTime localDateTime;
    private ArrayList<ProductItem> productAddedList;
    private double totalSum;

    public Invoice(Customer customer,LocalDateTime localDateTime, ArrayList<ProductItem> productAdded, double totalSum) {
        this.customer = customer;
        this.id = invoiceCount++;
        this.localDateTime = localDateTime;
        this.productAddedList = productAdded;
        this.totalSum = totalSum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public ArrayList<ProductItem> getProductAdded() {
        return productAddedList;
    }

    public void setProductAdded(ArrayList<ProductItem> productAdded) {
        this.productAddedList = productAdded;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", localDateTime=" + localDateTime +
                ", productAddedList=" + productAddedList +
                ", totalSum=" + totalSum +
                '}';
    }
}
