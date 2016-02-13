package com.flight.search.repository;

import com.flight.search.model.Airport;

public interface AirportRepository {

    Airport findByCode(String originCode);
}
