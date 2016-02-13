package com.flight.search.view;

public class FlightSearchResult {

    private String flightCode;
    private float totalPrice;

    public FlightSearchResult(String flightCode, float totalPrice) {
        this.flightCode = flightCode;
        this.totalPrice = totalPrice;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
