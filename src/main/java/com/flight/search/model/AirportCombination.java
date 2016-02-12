package com.flight.search.model;

public class AirportCombination {

    private Airport origin;
    private Airport destination;

    public AirportCombination(Airport origin, Airport destination) {
        this.origin = origin;
        this.destination = destination;
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

    public boolean equals(Object o){
        if(o == null) {
            return false;
        }
        if(!(o instanceof AirportCombination)) {
            return false;
        }

        AirportCombination other = (AirportCombination) o;
        return this.origin == other.origin && this.destination == other.destination;
    }

    public int hashCode(){
        int result = 17;
        result = 31 * result + this.origin.hashCode();
        result = 31 * result + this.destination.hashCode();
        return result;
    }
}
