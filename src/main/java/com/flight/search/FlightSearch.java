package com.flight.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.flight.search.model.AirportCombination;
import com.flight.search.model.Flight;

public class FlightSearch {

    private Map<AirportCombination, List<Flight>> availableFlights;

    public FlightSearch(Map<AirportCombination, List<Flight>> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public List<SearchResult> run(SearchCriteria criteria) {
        criteria.validate();

        List<SearchResult> results = new ArrayList<>();
        List<Flight> flightsForCombination = availableFlights.get(criteria.getAirportCombination());

        if(flightsForCombination != null) {
            for (Flight flight : flightsForCombination) {
                results.add(new SearchResult());
            }
        }

        return results;
    }
}
