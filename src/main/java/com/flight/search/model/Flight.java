package com.flight.search.model;

public class Flight {

    private Airport origin;
    private Airport destination;
    private String flightNumber;
    private float price;

    public Flight(Airport origin, Airport destination, String flightNumber, float price) {
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.price = price;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
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
