package com.flight.search;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.flight.search.model.Airport;
import com.flight.search.model.Flight;
import com.flight.search.utils.DateUtils;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FlightSearchTest
{
    private static final Date TODAY = DateUtils.cleanDate(new Date());

    private FlightSearch flightSearch;

    @Before
    public void setup() {
        List<Flight> flights = loadFlightsFromCsv();
        flightSearch = new FlightSearch(flights);
    }

    @Test
    public void runVerifyCriteriaValidation() {
        SearchCriteria criteria = mock(SearchCriteria.class);
        flightSearch.run(criteria);
        verify(criteria).validate();
    }

    @Test
    public void runWhenNoFlightFoundThenReturnEmptyList() {
        SearchCriteria criteria = new SearchCriteria(Airport.FCO, Airport.LHR, TODAY, 1, 1, 1);
        List<SearchResult> results = flightSearch.run(criteria);

        assertTrue(results.isEmpty());
    }

    private List<Flight> loadFlightsFromCsv() {
        return FlightCsvReader.run();
    }
}
