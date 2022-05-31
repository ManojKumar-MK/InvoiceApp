package com.manojkumar.invoice.dao;

import com.manojkumar.invoice.db.DBSource;
import com.manojkumar.invoice.model.Invoice;

import java.util.List;

public class InvoiceDao {
    private static List<Invoice> invoiceList = DBSource.getInvoices();

    public void addInvoice(Invoice invoice)
    {
        invoiceList.add(invoice);
        System.out.println("Invoice Generated successfully.");

    }
    public List<Invoice> getAll()
    {
        return invoiceList;
    }
}
