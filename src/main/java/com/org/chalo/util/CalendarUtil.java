package com.org.chalo.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class CalendarUtil {

    public static String getCurrentDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return today.format(formatter);
    }

    public static String addDaysToDate(String dateStr, int daysToAdd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        try {
            LocalDate date = LocalDate.parse(dateStr, formatter);
            LocalDate newDate = date.plusDays(daysToAdd);
            return newDate.format(formatter);
        } catch (DateTimeParseException e) {
            return "Invalid date format";
        }
    }

    public static String getCurrentDateInEnglishFormat() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy", Locale.ENGLISH);
        return currentDate.format(formatter);
    }

    public static String addDaysToEnglishFormatDate(String dateStr, int daysToAdd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dateStr, formatter);
        LocalDate newDate = date.plusDays(daysToAdd);
        return newDate.format(formatter);
    }

}
