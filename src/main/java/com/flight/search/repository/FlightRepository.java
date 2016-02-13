package com.flight.search.repository;

import java.util.List;

import com.flight.search.model.Flight;

public interface FlightRepository {

    public List<Flight> findAll();
}
