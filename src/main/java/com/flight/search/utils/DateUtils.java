package com.flight.search.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtils {

    public static LocalDate addDays(LocalDate date, long amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }

        return date.plusDays(amount);
    }

    public static long daysBetween(LocalDate dateBefore, LocalDate dateAfter) {
        if (dateAfter.isBefore(dateBefore)) {
            throw new IllegalArgumentException("LocalDateAfter is previous to LocalDateBefore");
        }
        return dateBefore.until(dateAfter, ChronoUnit.DAYS);
    }
}
