package com.flight.search.service;

import java.util.List;

import com.flight.search.view.FlightSearchCriteria;
import com.flight.search.view.FlightSearchResult;

public interface FlightService {

    List<FlightSearchResult> search(FlightSearchCriteria criteria);
}
