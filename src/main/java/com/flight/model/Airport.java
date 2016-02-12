package com.flight.model;

public enum Airport {
    MAD ("Madrid"),
    LHR ("London"),
    CDG ("Paris"),
    FRA ("Frakfurt"),
    IST ("Istanbul"),
    AMS ("Amsterdam"),
    FCO ("Rome"),
    CPH ("Copenhagen");

    private final String description;

    private Airport(String description) {
        this.description = description;
    }
}
