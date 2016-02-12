package com.flight.search;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.flight.model.Airport;
import com.flight.model.FlightSearchCriteria;
import com.flight.utils.DateUtils;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FlightSearchTest
{
    private static final Airport ORIGIN = Airport.CPH;
    private static final Airport DESTINATION = Airport.FRA;
    private static final Date TODAY = DateUtils.cleanDate(new Date());

    private FlightSearch flightSearch = new FlightSearch();

    @Test
    public void runVerifyCriteriaValidation() {
        FlightSearchCriteria criteria = mock(FlightSearchCriteria.class);
        flightSearch.run(criteria);
        verify(criteria).validate();
    }

    @Test
    public void runWhenNoFlightFoundThenReturnEmptyList() {
        FlightSearchCriteria criteria = new FlightSearchCriteria(Airport.FCO, Airport.LHR, TODAY, 1, 1, 1);
        List<SearchResult> results = flightSearch.run(criteria);

        assertTrue(results.isEmpty());
    }
}
