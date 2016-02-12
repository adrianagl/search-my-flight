package com.flight.search.utils;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DateUtilsTest {

    @Test(expected = IllegalArgumentException.class )
    public void addDaysWhenDateIsNullReturnException() {
        DateUtils.addDays(null, 1);
        fail("An exception was expected");
    }

    @Test
    public void addDaysWhenDateIsNotNullReturnNewDate() {
        Date newDate = DateUtils.addDays(createMockedDate(), 1);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);

        assertEquals(2000, calendar.get(Calendar.YEAR));
        assertEquals(Calendar.FEBRUARY, calendar.get(Calendar.MONTH));
        assertEquals(1, calendar.get(Calendar.DATE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void cleanDateWhenDateIsNullThenReturnException() {
        DateUtils.cleanDate(null);
        fail("An exception was expected");
    }

    @Test
    public void cleanDateWhenDateIsNotNullThenReturnCleanDate() {
        Date cleanDate = DateUtils.cleanDate(createMockedDate());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cleanDate);
        assertEquals(2000, calendar.get(Calendar.YEAR));
        assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
        assertEquals(31, calendar.get(Calendar.DATE));
        assertEquals(0, calendar.get(Calendar.HOUR));
        assertEquals(0, calendar.get(Calendar.MINUTE));
    }

    private Date createMockedDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 31, 1, 30);
        return calendar.getTime();
    }
}
