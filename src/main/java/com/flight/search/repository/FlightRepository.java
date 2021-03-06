package com.flight.search.repository;

import java.util.List;

import com.flight.search.model.Flight;
import com.flight.search.model.Route;

public interface FlightRepository {

    List<Flight> findByRoute(Route route);
}
