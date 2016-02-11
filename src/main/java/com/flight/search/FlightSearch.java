package com.flight.search;

import java.util.Date;

import com.flight.exception.MandatoryValueException;
import com.flight.exception.PassengersException;
import com.flight.utils.StringUtils;

public class FlightSearch {

    public static void run(String origin, String destination, Date date, int adults, int children, int infants) {
        validateFields(origin, destination, date, adults, children, infants);
    }

    private static void validateFields(String origin, String destination, Date date, int adults, int children, int infants) {
        if(StringUtils.isEmpty(origin)) {
            throw new MandatoryValueException("Origin airport must be introduced");
        }

        if(StringUtils.isEmpty(destination)) {
            throw new MandatoryValueException("Destination airport must be introduced");
        }

        if(date == null) {
            throw new MandatoryValueException("Departure date must be introduced");
        }

        if(getTotalPassengers(adults, children, infants) == 0) {
            throw new PassengersException("Indicate at least one passenger");
        }
    }

    private static int getTotalPassengers(int adults, int children, int infants) {
        return adults + children + infants;
    }
}
