package com.flight.search.model;

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
}
