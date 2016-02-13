package com.flight.search.utils;

import java.time.LocalDate;
import java.time.Month;

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
        LocalDate originalDate = LocalDate.of(2000, Month.JANUARY, 31);
        LocalDate newDate = DateUtils.addDays(originalDate, 1);
        LocalDate expectedDate = LocalDate.of(2000, Month.FEBRUARY, 1);

        assertEquals(expectedDate, newDate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void daysBetweenWhenDateBeforeIsAfterDateAfterThenReturnException() {
        LocalDate dateBefore = LocalDate.of(2000, Month.JANUARY, 15);
        LocalDate dateAfter = LocalDate.of(2000, Month.JANUARY, 14);

        DateUtils.daysBetween(dateBefore, dateAfter);
        fail("An exception was expected");
    }

    @Test
    public void daysBetween() {
        LocalDate dateBefore = LocalDate.of(2000, Month.JANUARY, 15);
        LocalDate dateAfter = LocalDate.of(2000, Month.FEBRUARY, 15);

        assertEquals(31, DateUtils.daysBetween(dateBefore, dateAfter));
    }
}
