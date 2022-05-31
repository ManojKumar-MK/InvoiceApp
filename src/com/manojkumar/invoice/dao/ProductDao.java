package com.manojkumar.invoice.dao;

import com.manojkumar.invoice.model.Customer;
import com.manojkumar.invoice.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private ArrayList<Product> products = new ArrayList<>();
    // Crud

    { // instance block
        products.add(new Product("Dettol",20));
        products.add(new Product("LifeBoy",30));
        products.add(new Product("Gokul Sandal",40));
        products.add(new Product("Shampoo",20));
        products.add(new Product("Chik",10));
        products.add(new Product("Cinthal",50));
    }

    public void add(Product product)
    {
        products.add(product);
        System.out.println("Product Added Successfully.");

    }
    public boolean isExist(int productId) {
        for (Product product: products
        ) {
            if(product.getId() == productId)
                return true;
        }

        return false;
    }
    public List<Product> getAll()
    {
        return products;
    }

    public Product getProduct(int id) {
        Product result = null;
        for (Product p: products) {
            if(p.getId() == id)
                result = p;

        }
        return result;
    }
}
