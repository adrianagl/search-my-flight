package com.flight.search.model;

public class Flight {

    private Route route;
    private String flightNumber;
    private float price;

    private Flight(Airport origin, Airport destination, String flightNumber, float price) {
        this.route = new Route(origin, destination);
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}