package com.flight.search;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.flight.search.model.Route;
import com.flight.search.repository.AirlineRepository;
import com.flight.search.repository.AirportRepository;
import com.flight.search.repository.FlightRepository;
import com.flight.search.service.DefaultFlightService;
import com.flight.search.utils.DateUtils;
import com.flight.search.utils.TestUtils;
import com.flight.search.view.FlightSearchCriteria;
import com.flight.search.view.FlightSearchResult;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DefaultFlightServiceTest
{
    private static final Date TODAY = new Date();
    private static final Date DATE_IN_30_DAYS = DateUtils.addDays(TODAY, 31);

    private FlightRepository flightRepository = mock(FlightRepository.class);
    private AirportRepository airportRepository = mock(AirportRepository.class);
    private AirlineRepository airlineRepository = mock(AirlineRepository.class);

    private DefaultFlightService service = new DefaultFlightService();

    @Before
    public void setUp() {
        TestUtils.setUpData();

        service.setFlightRepository(flightRepository);
        service.setAirportRepository(airportRepository);
    }

    @Test(expected = IllegalArgumentException.class)
    public void searchWhenAirportNotFoundThenReturnException() {
        FlightSearchCriteria criteria = new FlightSearchCriteria("LLL", "MAD",
                TODAY, 1, 1, 1);

        service.search(criteria);
        verify(airportRepository).findByCode("LLL");
    }

    @Test
    public void searchWhenFlightNotFoundThenReturnEmptyList() {
        FlightSearchCriteria criteria = buildCriteriaAndMockData("MAD", "MAD", TODAY, 1, 1, 1);

        List<FlightSearchResult> result = service.search(criteria);

        assertTrue(result.isEmpty());

        verify(airportRepository, times(2)).findByCode(anyString());
        verify(flightRepository).findByRoute(any(Route.class));
    }

    @Test
    public void searchMoreThan30Days() {
        FlightSearchCriteria criteria = buildCriteriaAndMockData("AMS", "FRA", DATE_IN_30_DAYS, 1, 0, 0);

        List<FlightSearchResult> result = service.search(criteria);

        assertEquals(3, result.size());
        validateResult(result.get(0), "TK2372", 157.6);
        validateResult(result.get(1), "TK2659", 198.4);
        validateResult(result.get(2), "LH5909", 90.4);


        verify(airportRepository, times(2)).findByCode(anyString());
        verify(flightRepository).findByRoute(any(Route.class));
        verify(airlineRepository).findByCode(anyString());
    }

    private FlightSearchCriteria buildCriteriaAndMockData(String origin, String destination, Date date, int adults, int children, int infants) {
        Route route = TestUtils.getRoute("MAD", "MAD");
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

    private void mockAirlineRepositoryResultsForCode(String code) {
        when(airlineRepository.findByCode(code)).thenReturn(TestUtils.getAirlineByCode(code));
    }

    private void validateResult(FlightSearchResult result, String flightCode, double totalPrice) {
        assertEquals(flightCode, result.getFlightCode());
        assertTrue(totalPrice == result.getTotalPrice());
    }
}
