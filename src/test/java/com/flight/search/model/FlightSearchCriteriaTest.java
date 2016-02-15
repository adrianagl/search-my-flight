package com.flight.search.model;


import java.time.LocalDate;

import org.junit.Test;

import com.flight.search.utils.DateUtils;
import static org.junit.Assert.fail;

public class FlightSearchCriteriaTest {

    private static final String ORIGIN = "CPH";
    private static final String DESTINATION = "FRA";
    private static final LocalDate TODAY = LocalDate.now();

    @Test(expected = IllegalArgumentException.class)
    public void validateWhenOriginIsNullThenReturnException() {
        FlightSearchCriteria criteria = new FlightSearchCriteria(null, DESTINATION, TODAY, 1, 1, 1);
        criteria.validate();
        fail("An exception should have been thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWhenOriginIsEmptyThenReturnException() {
        FlightSearchCriteria criteria = new FlightSearchCriteria("", DESTINATION, TODAY, 1, 1, 1);
        criteria.validate();
        fail("An exception should have been thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWhenDestinationIsNullThenReturnException() {
        FlightSearchCriteria criteria = new FlightSearchCriteria(ORIGIN, null, TODAY, 1, 1, 1);
        criteria.validate();
        fail("An exception should have been thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWhenDestinationIsEmptyThenReturnException() {
        FlightSearchCriteria criteria = new FlightSearchCriteria(ORIGIN, "", TODAY, 1, 1, 1);
        criteria.validate();
        fail("An exception should have been thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWhenLocalDateIsNullThenReturnException() {
        FlightSearchCriteria criteria = new FlightSearchCriteria(ORIGIN, DESTINATION, null, 1, 1, 1);
        criteria.validate();
        fail("An exception should have been thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWhenLocalDateIsPastThenReturnException() {
        LocalDate pastLocalDate = DateUtils.addDays(TODAY, -1);
        FlightSearchCriteria criteria = new FlightSearchCriteria(ORIGIN, DESTINATION, pastLocalDate, 1, 1, 1);
        criteria.validate();
        fail("An exception should have been thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWhenZeroPassengersThenReturnException() {
        FlightSearchCriteria criteria = new FlightSearchCriteria(ORIGIN, DESTINATION, TODAY, 0, 0, 0);
        criteria.validate();
        fail("An exception should have been thrown");
    }

    @Test
    public void validateWhenValidParametersThenNoExceptionIsThrown() {
        FlightSearchCriteria criteria = new FlightSearchCriteria(ORIGIN, DESTINATION, TODAY, 1, 0, 0);
        criteria.validate();
    }
}
