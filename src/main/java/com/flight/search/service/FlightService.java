package com.flight.search.service;

import java.util.List;

import com.flight.search.model.FlightSearchCriteria;
import com.flight.search.model.FlightSearchResult;

public interface FlightService {

    List<FlightSearchResult> search(FlightSearchCriteria criteria);
}
