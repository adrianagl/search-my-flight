package com.flight.search;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.flight.search.repository.FlightRepository;
import com.flight.search.utils.DateUtils;
import com.flight.search.utils.TestUtils;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FlightSearchTest
{
    private static final Date TODAY = DateUtils.cleanDate(new Date());

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightSearch flightSearch = new FlightSearch();

    @Before
    public void setUp() {
        TestUtils.setUpData();

        when(flightRepository.findAll()).thenReturn(TestUtils.getFlights());
    }

    @Test
    public void runVerifyCriteriaValidation() {
        SearchCriteria criteria = mock(SearchCriteria.class);
        flightSearch.run(criteria);
        verify(criteria).validate();
    }

    @Test
    public void runWhenFlightNotFoundThenReturnEmptyList() {
        SearchCriteria criteria = new SearchCriteria("MAD", "MAD", TODAY, 1, 1, 1);

        List<SearchResult> result = flightSearch.run(criteria);

        assertTrue(result.isEmpty());
    }
}
