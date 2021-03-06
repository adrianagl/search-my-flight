package com.flight.search.service;

import java.util.ArrayList;
import java.util.List;

import com.flight.search.calculator.PriceCalculator;
import com.flight.search.model.Airport;
import com.flight.search.model.Flight;
import com.flight.search.model.Route;
import com.flight.search.repository.AirportRepository;
import com.flight.search.repository.FlightRepository;
import com.flight.search.model.FlightSearchCriteria;
import com.flight.search.model.FlightSearchResult;

public class DefaultFlightService {

    private FlightRepository flightRepository;
    private AirportRepository airportRepository;

    public List<FlightSearchResult> search(FlightSearchCriteria criteria) {
        criteria.validate();

        Route route = getRoute(criteria);
        List<FlightSearchResult> results = new ArrayList<>();

        List<Flight> flights = flightRepository.findByRoute(route);
        for(Flight flight : flights) {
            float totalPrice = PriceCalculator.calculateTotalPrice(flight, criteria);
            FlightSearchResult result = new FlightSearchResult(flight.getFlightCode(), totalPrice);
            results.add(result);
        }

        return results;
    }

    private Route getRoute(FlightSearchCriteria criteria) {
        Airport originAirport = airportRepository.findByCode(criteria.getOriginAirport());
        Airport destinationAirport = airportRepository.findByCode(criteria.getDestinationAirport());

        if(originAirport == null) {
            throw new IllegalArgumentException("Origin airport not found");
        }
        if(destinationAirport == null) {
            throw new IllegalArgumentException("Destination airport not found");
        }

        return new Route(originAirport, destinationAirport);
    }

    public void setFlightRepository(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void setAirportRepository(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }
}
