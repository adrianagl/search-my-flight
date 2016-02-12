package com.flight.search;

import com.flight.model.FlightSearchCriteria;

public class FlightSearch {

    public void run(FlightSearchCriteria flightSearchCriteria) {
        flightSearchCriteria.validate();
    }
}
