package com.flight.search.model;

import java.util.Date;

import com.flight.exception.MandatoryValueException;
import com.flight.exception.PassengersException;
import com.flight.utils.StringUtils;

public class FlightSearchCriteria {

    private String origin;
    private String destination;
    private Date date;
    private int adults;
    private int children;
    private int infants;

    public FlightSearchCriteria(String origin, String destination, Date date, int adults, int children, int infants) {
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.adults = adults;
        this.children = children;
        this.infants = infants;
    }

    public void validate() {
        if(StringUtils.isEmpty(this.origin)) {
            throw new MandatoryValueException("Origin airport must be introduced");
        }

        if(StringUtils.isEmpty(destination)) {
            throw new MandatoryValueException("Destination airport must be introduced");
        }

        if(date == null) {
            throw new MandatoryValueException("Departure date must be introduced");
        }

        if(getTotalPassengers() == 0) {
            throw new PassengersException("Indicate at least one passenger");
        }
    }

    private int getTotalPassengers() {
        return adults + children + infants;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
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
