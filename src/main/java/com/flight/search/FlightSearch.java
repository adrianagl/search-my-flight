package com.flight.search;

import java.util.ArrayList;
import java.util.List;

import com.flight.search.model.Flight;

public class FlightSearch {

    private List<Flight> availableFlights;

    public FlightSearch(List<Flight> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public List<SearchResult> run(SearchCriteria criteria) {
        criteria.validate();

        List<SearchResult> results = new ArrayList<>();

        for(Flight flight : availableFlights) {
            if(criteria.getOrigin() == flight.getOrigin() && criteria.getDestination() == flight.getDestination()) {
                results.add(new SearchResult());
            }
        }

        return results;
    }

    public List<Flight> getAvailableFlights() {
        return availableFlights;
    }

    public void setAvailableFlights(List<Flight> availableFlights) {
        this.availableFlights = availableFlights;
    }
}
