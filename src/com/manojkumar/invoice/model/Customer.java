package com.manojkumar.invoice.model;

import java.util.ArrayList;

public class Customer {
    private static int idCount = 1;
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private ArrayList<Invoice> myInvoices = new ArrayList<>();
    private int totalSalesCount;
    private double totalSalesAmount;

    public Customer(String name, String phoneNumber, String email) {
        this.id = idCount++;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }

    public int getId() {
        return id;
    }

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Invoice> getMyInvoices() {
        return myInvoices;
    }

    private void updateSalesCount(int count)
    {
        this.totalSalesCount = this.totalSalesCount + count;
    }

    private void updateSalesAmount(double amount)
    {
        this.totalSalesAmount = totalSalesAmount + amount;
    }
    public void addInvoice(Invoice invoice) // Add in Customer
    {
        myInvoices.add(invoice);
        updateSalesCount(1);  // update count
        updateSalesAmount(invoice.getTotalSum());  // update sales amount

    }

    public void setMyInvoices(ArrayList<Invoice> myInvoices) {
        this.myInvoices = myInvoices;
    }

    public int getTotalSalesCount() {
        return totalSalesCount;
    }

    public void setTotalSalesCount(int totalSalesCount) {
        this.totalSalesCount = totalSalesCount;
    }

    public double getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public void setTotalSalesAmount(double totalSalesAmount) {
        this.totalSalesAmount = totalSalesAmount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", myInvoices=" + myInvoices +
                ", totalSalesCount=" + totalSalesCount +
                ", totalSalesAmount=" + totalSalesAmount +
                '}';
    }
}
