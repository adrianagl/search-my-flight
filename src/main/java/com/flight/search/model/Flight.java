package com.flight.search.model;

public class Flight {

    private Route route;
    private String flightNumber;
    private double price;

    public Flight(Route route, String flightNumber, double price) {
        this.route = route;
        this.flightNumber = flightNumber;
        this.price = price;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Airport getOrigin() {
        return route.getOrigin();
    }

    public Airport getDestination() {
        return route.getDestination();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
