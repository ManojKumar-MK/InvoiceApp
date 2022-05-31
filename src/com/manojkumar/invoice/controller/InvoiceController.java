package com.manojkumar.invoice.controller;

import com.manojkumar.invoice.dao.InvoiceDao;
import com.manojkumar.invoice.model.Customer;
import com.manojkumar.invoice.model.Invoice;
import com.manojkumar.invoice.model.Product;
import com.manojkumar.invoice.model.ProductItem;
import com.manojkumar.invoice.utils.Constant;
import com.manojkumar.invoice.utils.Helper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoiceController {
    private static Scanner sc = new Scanner(System.in);
    private static InvoiceDao invoiceDao;

    static {
        invoiceDao = new InvoiceDao();
    }

    public static void addInvoice()
    {
        Customer c = CustomerController.getCustomer();  // Check is Customer Exist
       if(c != null)
       {
           System.out.println("Authenticated ----> ");
           ProductController.listProduct();

           boolean exit = false;

           ArrayList<ProductItem> productItems = new ArrayList<>();
           double totalSum = 0; // For Invoice

           while (!exit) {
               Product p = ProductController.getProduct();  // Get product by id
               if (p != null) { //

                   // Product Exist Then You Can add in product item
                   System.out.println("Enter the quantity : ");
                   int qty = sc.nextInt();
                   p.updateSalesCount(qty); // Updating Product Sales Count
                   double total = qty * p.getPrice(); //  Get Quantity * Price
                   totalSum = totalSum + total;
                   ProductItem productItem = new ProductItem(p.getName(), p.getPrice(), qty, total); // Product Item Generated
                   productItems.add(productItem);
               }
               else
               {
                   System.out.println("No Product in the id");
               }
               System.out.println("Do you want to add more ? Press 1");
               int choice = sc.nextInt();
               if(choice != 1)
                   exit = true; // then break

           }
           // add invoice
           if(!productItems.isEmpty()) {

               Invoice invoice = new Invoice(c,LocalDateTime.now(), productItems, totalSum);
               invoiceDao.addInvoice(invoice);
               CustomerController.addInvoice(c,invoice);  // Add in Customer list also

               ProductItem.productIdCount = 1;  // Id
           }
           else
               System.out.println("No Items Added Invoice Generte Failed");
       }
       else
       {
           System.out.println("No Customer in the Given id");
       }

    }

    public static void listInvoice()
    {
        List<Invoice> invoiceList = invoiceDao.getAll();

        if(invoiceList.isEmpty())
            System.out.println("No Invoices not generated yet");

        else {

            for (Invoice in: invoiceList) {
                System.out.printf("--------------------------- %s-----------------------------------",Constant.COMPANY_NAME);
                System.out.println();
                System.out.printf("%30s : %10s\n","NAME",in.getCustomer().getName());
                System.out.printf("%30s : %10s\n","PNUMBER",in.getCustomer().getPhoneNumber());

                System.out.printf("%5s : %2d  %20s : %10s","No",in.getId(),"Date", Helper.dateToString(in.getLocalDateTime()));
                System.out.println();
                System.out.println("--------------------------------------------------------------");
                System.out.printf("%5s | %10s | %5s | %5s | %5s","ID","NAME","PRICE","QTY","TOTAL");
                System.out.println();
                for(ProductItem p : in.getProductAdded())
                {
                    System.out.printf("%5d | %10s | %.2f | %5d | %.2f",p.getId(),p.getName(),p.getPrice(),p.getQty(),p.getTotal());
                    System.out.println();
                }
                System.out.println("--------------------------------------------------------------");
                System.out.printf("%40s : %.2f" , "TOTAL",in.getTotalSum());
                System.out.println();
                System.out.println("--------------------------------------------------------------");


            }
            System.out.println("--------------------------------------------------------------");

        }
    }
}
