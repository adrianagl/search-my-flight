package com.flight.search;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.flight.search.model.Airport;
import com.flight.search.model.AirportCombination;
import com.flight.search.model.Flight;
import com.flight.search.utils.DateUtils;
import com.flight.search.utils.FlightCsvReader;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FlightSearchTest
{
    private static final Date TODAY = DateUtils.cleanDate(new Date());

    private FlightSearch flightSearch;

    @Before
    public void setup() {
        Map<AirportCombination, List<Flight>> flights = loadFlightsFromCsv();
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

    private Map<AirportCombination, List<Flight>> loadFlightsFromCsv() {
        String csvFilePath = getClass().getClassLoader().getResource("complete_list_flights.csv").getFile();
        FlightCsvReader reader = new FlightCsvReader(csvFilePath);
        return reader.run();
    }
}
