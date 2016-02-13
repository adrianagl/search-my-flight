package com.flight.search;

import java.util.Date;

import org.junit.Test;

import com.flight.search.utils.DateUtils;
import static org.junit.Assert.fail;

public class SearchCriteriaTest {

    private static final String ORIGIN = "CPH";
    private static final String DESTINATION = "FRA";
    private static final Date TODAY = DateUtils.cleanDate(new Date());

    @Test(expected = IllegalArgumentException.class)
    public void validateWhenOriginIsNullThenReturnException() {
        SearchCriteria criteria = new SearchCriteria(null, DESTINATION, TODAY, 1, 1, 1);
        criteria.validate();
        fail("An exception should have been thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWhenOriginIsEmptyThenReturnException() {
        SearchCriteria criteria = new SearchCriteria("", DESTINATION, TODAY, 1, 1, 1);
        criteria.validate();
        fail("An exception should have been thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWhenDestinationIsNullThenReturnException() {
        SearchCriteria criteria = new SearchCriteria(ORIGIN, null, TODAY, 1, 1, 1);
        criteria.validate();
        fail("An exception should have been thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWhenDestinationIsEmptyThenReturnException() {
        SearchCriteria criteria = new SearchCriteria(ORIGIN, "", TODAY, 1, 1, 1);
        criteria.validate();
        fail("An exception should have been thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWhenDateIsNullThenReturnException() {
        SearchCriteria criteria = new SearchCriteria(ORIGIN, DESTINATION, null, 1, 1, 1);
        criteria.validate();
        fail("An exception should have been thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWhenDateIsPastThenReturnException() {
        Date pastDate = DateUtils.addDays(TODAY, -1);
        SearchCriteria criteria = new SearchCriteria(ORIGIN, DESTINATION, pastDate, 1, 1, 1);
        criteria.validate();
        fail("An exception should have been thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWhenZeroPassengersThenReturnException() {
        SearchCriteria criteria = new SearchCriteria(ORIGIN, DESTINATION, TODAY, 0, 0, 0);
        criteria.validate();
        fail("An exception should have been thrown");
    }

    @Test
    public void validateWhenValidParametersThenNoExceptionIsThrown() {
        SearchCriteria criteria = new SearchCriteria(ORIGIN, DESTINATION, TODAY, 1, 0, 0);
        criteria.validate();
    }
}
