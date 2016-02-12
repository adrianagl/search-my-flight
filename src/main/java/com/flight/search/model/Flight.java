package com.flight.search.model;

public class Flight {

    private AirportCombination airportCombination;
    private String flightNumber;
    private float price;

    private Flight(Airport origin, Airport destination, String flightNumber, float price) {
        this.airportCombination = new AirportCombination(origin, destination);
        this.flightNumber = flightNumber;
        this.price = price;
    }

    public static Flight build(String[] csvFlightLine) {
        return new Flight(Airport.valueOf(csvFlightLine[0]), Airport.valueOf(csvFlightLine[1]), csvFlightLine[2], Float.valueOf(csvFlightLine[3]));
    }

    public AirportCombination getAirportCombination() {
        return airportCombination;
    }

    public void setAirportCombination(AirportCombination airportCombination) {
        this.airportCombination = airportCombination;
    }

    public Airport getOrigin() {
        return airportCombination.getOrigin();
    }

    public Airport getDestination() {
        return airportCombination.getDestination();
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
