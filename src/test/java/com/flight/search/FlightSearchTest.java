package com.flight.search;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.flight.search.utils.DateUtils;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FlightSearchTest
{
    private static final Date TODAY = DateUtils.cleanDate(new Date());

    private FlightSearch flightSearch = new FlightSearch();

    @Before
    public void setUp() {
    }

    @Test
    public void runVerifyCriteriaValidation() {
        SearchCriteria criteria = mock(SearchCriteria.class);
        flightSearch.run(criteria);
        verify(criteria).validate();
    }
}
