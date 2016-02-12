package com.flight.search;

import com.flight.model.FlightSearchCriteria;

public class FlightSearch {

    public void run(FlightSearchCriteria criteria) {
        criteria.validate();
    }

    private void validateAirports(FlightSearchCriteria criteria) {

    }
}
