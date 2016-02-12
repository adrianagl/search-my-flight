package com.flight.model;

import java.util.Date;

import com.flight.utils.DateUtils;
import com.flight.utils.StringUtils;

public class FlightSearchCriteria {

    private Airport origin;
    private Airport destination;
    private Date date;
    private int adults;
    private int children;
    private int infants;

    public FlightSearchCriteria(Airport origin, Airport destination, Date date, int adults, int children, int infants) {
        this.origin = origin;
        this.destination = destination;
        this.date = DateUtils.cleanDate(date);
        this.adults = adults;
        this.children = children;
        this.infants = infants;
    }

    public void validate() {
        if(this.origin == null) {
            throw new IllegalArgumentException("Origin airport must not be empty");
        }

        if(this.destination == null) {
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
