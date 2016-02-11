package com.flight.search.model;

import java.util.Date;

import org.junit.Test;

import com.flight.exception.MandatoryValueException;
import com.flight.exception.PassengersException;
import com.flight.search.FlightSearch;

public class FlightSearchCriteriaTest {

    private static final String MAD = "MAD";
    private static final String BCN = "BCN";
    private static final Date TODAY = new Date();

    private FlightSearch flightSearch = new FlightSearch();

    @Test(expected = MandatoryValueException.class)
    public void whenOriginIsNullThenReturnException() {
        FlightSearchCriteria criteria = new FlightSearchCriteria(null, MAD, TODAY, 1, 1, 1);
        criteria.validate();
    }

    @Test(expected = MandatoryValueException.class)
    public void whenOriginIsEmptyThenReturnException() {
        FlightSearchCriteria criteria = new FlightSearchCriteria("", MAD, TODAY, 1, 1, 1);
        criteria.validate();
    }

    @Test(expected = MandatoryValueException.class)
    public void whenDestinationIsNullThenReturnException() {
        FlightSearchCriteria criteria = new FlightSearchCriteria(MAD, null, TODAY, 1, 1, 1);
        criteria.validate();
    }

    @Test(expected = MandatoryValueException.class)
    public void whenDestinationIsEmptyThenReturnException() {
        FlightSearchCriteria criteria = new FlightSearchCriteria(MAD, "", TODAY, 1, 1, 1);
        criteria.validate();
    }

    @Test(expected = MandatoryValueException.class)
    public void whenDateIsNullThenReturnException() {
        FlightSearchCriteria criteria = new FlightSearchCriteria(MAD, BCN, null, 1, 1, 1);
        criteria.validate();
    }

    @Test(expected = PassengersException.class)
    public void whenZeroPassengersThenReturnException() {
        FlightSearchCriteria criteria = new FlightSearchCriteria(MAD, BCN, TODAY, 0, 0, 0);
        criteria.validate();
    }

    @Test
    public void whenValidParametersThenNoExceptionIsThrown() {
        FlightSearchCriteria criteria = new FlightSearchCriteria(MAD, BCN, TODAY, 1, 0, 0);
        criteria.validate();
    }
}
