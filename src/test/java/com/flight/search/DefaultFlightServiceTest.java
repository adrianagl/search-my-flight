package com.flight.search;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.flight.search.model.Route;
import com.flight.search.repository.AirportRepository;
import com.flight.search.repository.FlightRepository;
import com.flight.search.service.DefaultFlightService;
import com.flight.search.utils.DateUtils;
import com.flight.search.utils.TestUtils;
import com.flight.search.view.FlightSearchCriteria;
import com.flight.search.view.FlightSearchResult;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DefaultFlightServiceTest
{
    private static final Date TODAY = DateUtils.cleanDate(new Date());

    private FlightRepository flightRepository = mock(FlightRepository.class);
    private AirportRepository airportRepository = mock(AirportRepository.class);

    private DefaultFlightService service = new DefaultFlightService();

    @Before
    public void setUp() {
        TestUtils.setUpData();

        service.setFlightRepository(flightRepository);
        service.setAirportRepository(airportRepository);
    }

    @Test(expected = IllegalArgumentException.class)
    public void runWhenAirportNotFoundThenReturnException() {
        FlightSearchCriteria criteria = new FlightSearchCriteria("LLL", "MAD",
                TODAY, 1, 1, 1);

        service.search(criteria);
        verify(airportRepository).findByCode("LLL");
    }

    @Test
    public void runWhenFlightNotFoundThenReturnEmptyList() {
        Route route = TestUtils.getRoute("MAD", "MAD");
        FlightSearchCriteria criteria = buildCriteriaAndMockData(route, TODAY, 1, 1, 1);

        List<FlightSearchResult> result = service.search(criteria);

        assertTrue(result.isEmpty());
        verify(airportRepository, times(2)).findByCode(anyString());
        verify(flightRepository).findByRoute(route);
    }

    private FlightSearchCriteria buildCriteriaAndMockData(Route route, Date date, int adults, int children, int infants) {
        FlightSearchCriteria criteria = new FlightSearchCriteria(route.getOriginCode(), route.getDestinationCode(),
                date, adults, children, infants);

        mockFlightRepositoryResultsForRoute(route);

        mockAirportRepositoryResultsForRoute(route);

        return criteria;
    }

    private void mockFlightRepositoryResultsForRoute(Route route) {
        when(flightRepository.findByRoute(route)).thenReturn(TestUtils.getFlightsByRoute(route));
    }

    private void mockAirportRepositoryResultsForRoute(Route route) {
        when(airportRepository.findByCode(route.getOriginCode())).thenReturn(TestUtils.getAirportByCode(route.getOriginCode()));
        when(airportRepository.findByCode(route.getDestinationCode())).thenReturn(TestUtils.getAirportByCode(route.getDestinationCode()));
    }
}
