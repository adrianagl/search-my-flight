package com.flight.search.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Date addDays(Date date, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, amount);
        return c.getTime();
    }

    public static Date cleanDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar origin = Calendar.getInstance();
        origin.setTime(date);

        Calendar cleanCalendar = Calendar.getInstance();
        cleanCalendar.set(origin.get(Calendar.YEAR), origin.get(Calendar.MONTH), origin.get(Calendar.DATE), 0, 0, 0);
        cleanCalendar.set(Calendar.MILLISECOND, 0);
        return cleanCalendar.getTime();
    }
}
