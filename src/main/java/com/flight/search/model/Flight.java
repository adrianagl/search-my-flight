package com.flight.search.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import com.flight.search.utils.DateUtils;

public class Flight {

    private Route route;
    private Airline airline;
    private String flightCode;
    private float basePrice;

    public Flight(Route route, Airline airline, String flightCode, float basePrice) {
        this.route = route;
        this.airline = airline;
        this.flightCode = flightCode;
        this.basePrice = basePrice;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Airline getAirline() {
        return airline;
    }

    public float getAirlineInfantPrice() {
        return airline == null ? null : airline.getInfantPrice();
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airport getOrigin() {
        return route.getOrigin();
    }

    public Airport getDestination() {
        return route.getDestination();
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public float getPriceWithDateDiscount(LocalDate searchDate) {
        LocalDate today = LocalDate.now();
        long daysUntil = DateUtils.daysBetween(today, searchDate);

        float percent;
        if(daysUntil > 30) {
            percent = 0.8f;
        } else if(30 >= daysUntil && daysUntil >= 16) {
            percent = 1;
        } else if(15 >= daysUntil && daysUntil >= 3) {
            percent = 1.2f;
        } else {
            percent = 1.5f;
        }
        float discountPrice = basePrice * percent;
        BigDecimal bd = new BigDecimal(discountPrice);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.floatValue();
    }
}
