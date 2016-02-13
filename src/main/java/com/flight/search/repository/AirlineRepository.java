package com.flight.search.repository;

import com.flight.search.model.Airline;

public interface AirlineRepository {

    Airline findByCode(String code);
}
