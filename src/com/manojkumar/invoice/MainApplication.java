package com.manojkumar.invoice;

import com.manojkumar.invoice.controller.CustomerController;
import com.manojkumar.invoice.controller.InvoiceController;
import com.manojkumar.invoice.controller.ProductController;
import com.manojkumar.invoice.utils.Constant;

import java.util.Scanner;

public class MainApplication {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exit = false;

        while (!exit)
        {
            printMenuOptions();
            System.out.println("Enter the choice : ");
            int choice = sc.nextInt(); // get choice
            switch (choice)
            {
                case 1:
                    System.out.println(Constant.ADD_GREET_C);
                    CustomerController.addCustomer();
                    break;

                case 2:
                    System.out.println(Constant.LIST_GREET_C);
                    CustomerController.listCustomer();
                    break;

                case 3:
                    System.out.println(Constant.ADD_GREET_P);
                    ProductController.addProduct();
                    break;

                case 4:
                    System.out.println(Constant.LIST_GREET_P);
                    ProductController.listProduct();
                    break;

                case 5:
                    System.out.println(Constant.ADD_GREET_I);
                    InvoiceController.addInvoice();
                    break;

                case 6:
                    System.out.println(Constant.LIST_GREET_I);
                    InvoiceController.listInvoice();
                    break;

                case 7:
                    System.out.println("Thank You For Using");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }

        }




    }

    private static void printMenuOptions() {
        System.out.printf("******* %10s *******\n",Constant.COMPANY_NAME);
        System.out.println("1.Add Customer");
        System.out.println("2.List Customer");
        System.out.println("3.Add Product");
        System.out.println("4.List Product");
        System.out.println("5.Generate Invoice");
        System.out.println("6.List Invoice");
        System.out.println("7.Exit");
    }
}
