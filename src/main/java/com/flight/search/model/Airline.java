package com.flight.search.model;

public class Airline {

    private String code;
    private String name;
    private float infantPrice;

    public Airline(String code, String name, float infantPrice) {
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

    public float getInfantPrice() {
        return infantPrice;
    }

    public void setInfantPrice(float infantPrice) {
        this.infantPrice = infantPrice;
    }
}
