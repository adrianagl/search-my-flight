package com.flight.search;

import java.util.Date;

import com.flight.search.model.Airport;
import com.flight.search.model.AirportCombination;
import com.flight.search.utils.DateUtils;

public class SearchCriteria {

    private AirportCombination airportCombination;
    private Date date;
    private int adults;
    private int children;
    private int infants;

    public SearchCriteria(Airport origin, Airport destination, Date date, int adults, int children, int infants) {
        this.airportCombination = new AirportCombination(origin, destination);
        this.date = DateUtils.cleanDate(date);
        this.adults = adults;
        this.children = children;
        this.infants = infants;
    }



    public void validate() {
        if(this.getOrigin() == null) {
            throw new IllegalArgumentException("Origin airport must not be empty");
        }

        if(this.getDestination() == null) {
            throw new IllegalArgumentException("Destination airport must not be empty");
        }

        if(this.date == null) {
            throw new IllegalArgumentException("Departure date must not be empty");
        }

        Date today = DateUtils.cleanDate(new Date());
        if(this.date.before(today)) {
            throw new IllegalArgumentException("Departure date must be today or after today");
        }

        if(getTotalPassengers() == 0) {
            throw new IllegalArgumentException("No passengers have been selected");
        }
    }

    private int getTotalPassengers() {
        return adults + children + infants;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getInfants() {
        return infants;
    }

    public void setInfants(int infants) {
        this.infants = infants;
    }
}
