package com.manojkumar.invoice.model;

public class ProductItem {
    public static int productIdCount = 1;
    private int id;
    private String name;
    private double price;
    private int qty;
    private double total;


    public ProductItem(String name, double price, int qty, double total) {
        this.id = productIdCount++;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.total = total;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", total=" + total +
                '}';
    }
}
