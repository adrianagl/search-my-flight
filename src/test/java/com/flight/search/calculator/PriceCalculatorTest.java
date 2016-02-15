package com.flight.search.calculator;

import java.time.LocalDate;

import org.junit.Test;

import com.flight.search.model.Flight;
import com.flight.search.model.FlightSearchCriteria;
import com.flight.search.utils.DateUtils;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PriceCalculatorTest {

    private static final float BASE_PRICE = 100;
    private static final LocalDate TODAY = LocalDate.now();
    private static final LocalDate YESTERDAY = DateUtils.addDays(LocalDate.now(), -1);
    private static final LocalDate DATE_MORE_THAN_30_DAYS = DateUtils.addDays(TODAY, 31);
    private static final LocalDate DATE_IN_20_DAYS = DateUtils.addDays(TODAY, 20);
    private static final LocalDate DATE_IN_12_DAYS = DateUtils.addDays(TODAY, 12);
    private static final LocalDate DATE_IN_2_DAYS = DateUtils.addDays(TODAY, 2);

    @Test
    public void getPriceWithDateDiscountMoreThan30Days() {
        validatePriceWithDaysDiscount(80, DATE_MORE_THAN_30_DAYS);
    }

    @Test
    public void getPriceWithDateDiscount20DaysBefore() {
        validatePriceWithDaysDiscount(100, DATE_IN_20_DAYS);
    }

    @Test
    public void getPriceWithDateDiscount12DaysBefore() {
        validatePriceWithDaysDiscount(120, DATE_IN_12_DAYS);
    }

    @Test
    public void getPriceWithDateDiscount2DaysBefore() {
        validatePriceWithDaysDiscount(150, DATE_IN_2_DAYS);
    }

    @Test
    public void getPriceWithDateDiscountToday() {
        validatePriceWithDaysDiscount(150, TODAY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getPriceWithDateDiscountYesterday() {
        PriceCalculator.getPriceWithDateDiscount(BASE_PRICE, YESTERDAY);
        fail("Exception was expected");
    }

    @Test
    public void roundPrice() {
        assertTrue(2.33f == PriceCalculator.roundPrice(2.333f));
    }

    @Test
    public void calculateTotalPriceMoreThan30Days() {
        testCalculateTotalPrice(DATE_MORE_THAN_30_DAYS, 143.6f);
    }

    @Test
    public void calculateTotalPrice20DaysBefore() {
        testCalculateTotalPrice(DATE_IN_20_DAYS, 177f);
    }

    @Test
    public void calculateTotalPrice12DaysBefore() {
        testCalculateTotalPrice(DATE_IN_12_DAYS, 210.4f);
    }

    @Test
    public void calculateTotalPrice2DaysBefore() {
        testCalculateTotalPrice(DATE_IN_2_DAYS, 260.5f);
    }

    private void validatePriceWithDaysDiscount(float expectedPrice, LocalDate flightDate) {
        float price = PriceCalculator.getPriceWithDateDiscount(BASE_PRICE, flightDate);
        assertTrue(expectedPrice == PriceCalculator.roundPrice(price));
    }

    private Flight mockFlight() {
        Flight flight = mock(Flight.class);
        when(flight.getAirlineInfantPrice()).thenReturn(10f);
        when(flight.getBasePrice()).thenReturn(100f);
        return flight;
    }

    private void testCalculateTotalPrice(LocalDate flightDate, float expectedPrice) {
        Flight flight = mockFlight();
        FlightSearchCriteria criteria = new FlightSearchCriteria("MAD", "BCN", flightDate, 1, 1, 1);

        float calculated = PriceCalculator.calculateTotalPrice(flight, criteria);
        assertTrue("Calculated was " + calculated, expectedPrice == calculated);
    }
}
