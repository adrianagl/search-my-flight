package com.flight.search.model;

public class Airline {

    private String code;
    private String name;
    private double infantPrice;

    public Airline(String code, String name, double infantPrice) {
        this.code = code;
        this.name = name;
        this.infantPrice = infantPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInfantPrice() {
        return infantPrice;
    }

    public void setInfantPrice(double infantPrice) {
        this.infantPrice = infantPrice;
    }
}
