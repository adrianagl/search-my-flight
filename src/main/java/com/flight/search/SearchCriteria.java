package com.flight.search;

import java.util.Date;

import com.flight.search.utils.DateUtils;
import com.flight.search.utils.StringUtils;

public class SearchCriteria {

    private String originAirport;
    private String destinationAirport;
    private Date date;
    private int adults;
    private int children;
    private int infants;

    public SearchCriteria(String originAirport, String destinationAirport, Date date, int adults, int children, int infants) {
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.date = DateUtils.cleanDate(date);
        this.adults = adults;
        this.children = children;
        this.infants = infants;
    }

    public void validate() {
        if(StringUtils.isEmpty(this.getOriginAirport())) {
            throw new IllegalArgumentException("Origin airport must not be empty");
        }

        if(StringUtils.isEmpty(this.getDestinationAirport())) {
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

    public String getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
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