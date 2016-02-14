package com.flight.search.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.flight.search.model.Airport;
import com.flight.search.model.Flight;
import com.flight.search.model.Route;
import com.flight.search.repository.AirportRepository;
import com.flight.search.repository.FlightRepository;
import com.flight.search.view.FlightSearchCriteria;
import com.flight.search.view.FlightSearchResult;

public class DefaultFlightService {

    private FlightRepository flightRepository;
    private AirportRepository airportRepository;

    public List<FlightSearchResult> search(FlightSearchCriteria criteria) {
        criteria.validate();

        Route route = getRoute(criteria);
        List<FlightSearchResult> results = new ArrayList<>();

        List<Flight> flights = flightRepository.findByRoute(route);
        for(Flight flight : flights) {
            float totalPrice = calculateTotalPrice(flight, criteria);
            FlightSearchResult result = new FlightSearchResult(flight.getFlightCode(), totalPrice);
            results.add(result);
        }

        return results;
    }

    private float calculateTotalPrice(Flight flight, FlightSearchCriteria criteria) {
        int adults = criteria.getAdults();
        int children = criteria.getChildren();
        int infants = criteria.getInfants();
        float infantPrice = flight.getAirlineInfantPrice();
        LocalDate searchDate = criteria.getDate();

        float priceWithDateDiscount = flight.getPriceWithDateDiscount(searchDate);

        float total = 0;

        //Adults
        total += adults * priceWithDateDiscount;

        //Children
        total += children * (0.67f * priceWithDateDiscount);

        //Infants
        total += infants * infantPrice;

        return roundPrice(total);
    }

    private float roundPrice(float price) {
        BigDecimal bd = new BigDecimal(String.valueOf(price));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.floatValue();
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
