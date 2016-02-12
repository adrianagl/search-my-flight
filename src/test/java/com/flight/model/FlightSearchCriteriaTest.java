package com.flight.model;

import java.util.Date;

import org.junit.Test;

import com.flight.utils.DateUtils;
import static org.junit.Assert.fail;

public class FlightSearchCriteriaTest {

    private static final Airport ORIGIN = Airport.CPH;
    private static final Airport DESTINATION = Airport.FRA;
    private static final Date TODAY = DateUtils.cleanDate(new Date());

    @Test(expected = IllegalArgumentException.class)
    public void validateWhenOriginIsNullThenReturnException() {
        FlightSearchCriteria criteria = new FlightSearchCriteria(null, DESTINATION, TODAY, 1, 1, 1);
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
    public void validateWhenDateIsNullThenReturnException() {
        FlightSearchCriteria criteria = new FlightSearchCriteria(ORIGIN, DESTINATION, null, 1, 1, 1);
        criteria.validate();
        fail("An exception should have been thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWhenDateIsPastThenReturnException() {
        Date pastDate = DateUtils.addDays(TODAY, -1);
        FlightSearchCriteria criteria = new FlightSearchCriteria(ORIGIN, DESTINATION, pastDate, 1, 1, 1);
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
