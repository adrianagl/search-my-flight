package com.flight.search.calculator;

import java.time.LocalDate;

import org.junit.Test;

import com.flight.search.utils.DateUtils;
import static org.junit.Assert.assertTrue;

public class PriceCalculatorTest {

    private static final float BASE_PRICE = 100;
    private static final LocalDate TODAY = LocalDate.now();
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

    private void validatePriceWithDaysDiscount(float expectedPrice, LocalDate flightDate) {
        float price = PriceCalculator.getPriceWithDateDiscount(BASE_PRICE, flightDate);
        assertTrue(expectedPrice == PriceCalculator.roundPrice(price));
    }
}
