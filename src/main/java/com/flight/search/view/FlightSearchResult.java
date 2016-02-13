package com.flight.search.view;

public class FlightSearchResult {

    private String flightCode;
    private double totalPrice;

    public FlightSearchResult(String flightCode, double totalPrice) {
        this.flightCode = flightCode;
        this.totalPrice = totalPrice;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
