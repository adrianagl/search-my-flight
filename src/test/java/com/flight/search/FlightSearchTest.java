package com.flight.search;

import org.junit.Test;

import com.flight.model.FlightSearchCriteria;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FlightSearchTest
{

    private FlightSearch flightSearch = new FlightSearch();

    @Test
    public void runVerifyCriteriaValidation() {
        FlightSearchCriteria criteria = mock(FlightSearchCriteria.class);
        flightSearch.run(criteria);
        verify(criteria).validate();
    }
}
