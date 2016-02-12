package com.flight.search;

import java.util.Date;

import org.junit.Test;

import com.flight.model.FlightSearchCriteria;
import com.flight.utils.DateUtils;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FlightSearchTest
{
    private static final String ORIGIN = "CPH";
    private static final String DESTINATION = "FRA";
    private static final String INEXISTENT_AIRPORT = "OTHER";
    private static final Date TODAY = DateUtils.cleanDate(new Date());

    private FlightSearch flightSearch = new FlightSearch();

    @Test
    public void runVerifyCriteriaValidation() {
        FlightSearchCriteria criteria = mock(FlightSearchCriteria.class);
        flightSearch.run(criteria);
        verify(criteria).validate();
    }
}
