package com.obider.transactionservice.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatter {
    public static LocalDate parseStringToDate(String stringDate){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(stringDate,formatter);
            return date;
        } catch (Exception e){
            return null;
        }
    }
}
