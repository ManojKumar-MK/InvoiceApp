package com.manojkumar.invoice.controller;

import com.manojkumar.invoice.dao.ProductDao;
import com.manojkumar.invoice.model.Product;
import com.manojkumar.invoice.utils.Constant;

import java.util.List;
import java.util.Scanner;

public class ProductController {
    private static Scanner sc = new Scanner(System.in);
    private static ProductDao productDao;

    static {
        productDao = new ProductDao();
    }

    public static boolean isExist() {
        System.out.println("Enter the Product Id");
        int id = sc.nextInt();
        return productDao.isExist(id);
    }

    public static Product getProduct()
    {
        System.out.println("Enter the Product Id");
        int id = sc.nextInt();
        return productDao.getProduct(id);
    }
    public static void addProduct()
    {
        System.out.println("Enter the product Name :");
        String name = sc.nextLine();
        System.out.println("Enter the Price of Product :");
        double price = sc.nextDouble();
        Product p = new Product(name,price);
        productDao.add(p);
    }
    public static void listProduct()
    {
        List<Product> list = productDao.getAll();

        System.out.printf("******* %10s *******\n", Constant.COMPANY_NAME);
        System.out.println();

        if(list.isEmpty())
            System.out.println("No Items added");
        else
        {

            System.out.printf("%2s | %10s | %5s | %6s","ID","NAME","PRICE","S.COUNT");
            System.out.println();
            for (Product p: list) {
                System.out.printf("%2d | %10s | %.2f | %6d",p.getId(),p.getName(),p.getPrice(),p.getTotalSaleCount());
                System.out.println();
            }
        }
    }
}
