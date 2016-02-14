package com.flight.search.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import com.flight.search.model.Flight;
import com.flight.search.utils.DateUtils;
import com.flight.search.view.FlightSearchCriteria;

public class PriceCalculator {

    private static final long DAYS_30 = 30;
    private static final long DAYS_16 = 16;
    private static final long DAYS_15 = 15;
    private static final long DAYS_3 = 3;
    private static final float PERCENT_67 = 0.67f;
    private static final float PERCENT_80 = 0.8f;
    private static final float PERCENT_100 = 1f;
    private static final float PERCENT_120 = 1.2f;
    private static final float PERCENT_150 = 1.5f;
    private static final int DECIMALS = 2;


    public static float getPriceWithDateDiscount(float basePrice, LocalDate searchDate) {
        LocalDate today = LocalDate.now();
        long daysUntil = DateUtils.daysBetween(today, searchDate);

        float percent;
        if(daysUntil > DAYS_30) {
            percent = PERCENT_80;
        } else if(DAYS_30 >= daysUntil && daysUntil >= DAYS_16) {
            percent = PERCENT_100;
        } else if(DAYS_15 >= daysUntil && daysUntil >= DAYS_3) {
            percent = PERCENT_120;
        } else {
            percent = PERCENT_150;
        }
        return basePrice * percent;
    }

    public static float calculateTotalPrice(Flight flight, FlightSearchCriteria criteria) {
        int adults = criteria.getAdults();
        int children = criteria.getChildren();
        int infants = criteria.getInfants();
        float infantPrice = flight.getAirlineInfantPrice();
        float basePrice = flight.getBasePrice();
        LocalDate searchDate = criteria.getDate();

        float priceWithDateDiscount = PriceCalculator.getPriceWithDateDiscount(basePrice, searchDate);

        //Adults
        float total = adults * priceWithDateDiscount;

        //Children
        total += children * (PERCENT_67 * priceWithDateDiscount);

        //Infants
        total += infants * infantPrice;

        return PriceCalculator.roundPrice(total);
    }

    public static float roundPrice(float price) {
        BigDecimal bd = new BigDecimal(String.valueOf(price));
        bd = bd.setScale(DECIMALS, RoundingMode.HALF_UP);
        return bd.floatValue();
    }
}
