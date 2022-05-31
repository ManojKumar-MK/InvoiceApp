package com.manojkumar.invoice.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Helper {
    public static void main(String[] args) {
        System.out.println(dateToString(LocalDateTime.now()));
    }
    public static String dateToString(LocalDateTime localDateTime)
    {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
        return localDateTime.format(dateTimeFormatter);
    }
}
