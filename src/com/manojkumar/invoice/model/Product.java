package com.manojkumar.invoice.model;

public class Product {
    private static int productIdCount = 1;
    private int id;
    private String name;
    private double price;
    private int totalSaleCount; // Qty added

    public Product(String name, double price) {
        this.id = productIdCount++;
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalSaleCount() {
        return totalSaleCount;
    }

    public void setTotalSaleCount(int totalSaleCount) {
        this.totalSaleCount = totalSaleCount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", totalSaleCount=" + totalSaleCount +
                '}';
    }

    public void updateSalesCount(int qty) {
        this.totalSaleCount = this.totalSaleCount+qty;
    }
}
