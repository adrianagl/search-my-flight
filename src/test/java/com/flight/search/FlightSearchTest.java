package com.flight.search;

import java.util.Date;

import org.junit.Test;

import com.flight.exception.MandatoryValueException;
import com.flight.exception.PassengersException;

public class FlightSearchTest
{
    private static final String MAD = "MAD";
    private static final String BCN = "BCN";
    private static final Date TODAY = new Date();

    @Test(expected = MandatoryValueException.class)
    public void whenOriginIsNullThenReturnException() {
        FlightSearch.run(null, MAD, TODAY, 1, 1, 1);
    }

    @Test(expected = MandatoryValueException.class)
    public void whenOriginIsEmptyThenReturnException() {
        FlightSearch.run("", MAD, TODAY, 1, 1, 1);
    }

    @Test(expected = MandatoryValueException.class)
    public void whenDestinationIsNullThenReturnException() {
        FlightSearch.run(MAD, null, TODAY, 1, 1, 1);
    }

    @Test(expected = MandatoryValueException.class)
    public void whenDestinationIsEmptyThenReturnException() {
        FlightSearch.run(MAD, "", TODAY, 1, 1, 1);
    }

    @Test(expected = MandatoryValueException.class)
    public void whenDateIsNullThenReturnException() {
        FlightSearch.run(MAD, BCN, null, 1, 1, 1);
    }

    @Test(expected = PassengersException.class)
    public void whenZeroPassengersThenReturnException() {
        FlightSearch.run(MAD, BCN, TODAY, 0, 0, 0);
    }
}
