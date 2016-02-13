package com.flight.search.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flight.search.model.Airline;
import com.flight.search.model.Airport;
import com.flight.search.model.Flight;
import com.flight.search.model.Route;

public class TestUtils {

    private static Map<String, Airport> airports = new HashMap<>();
    private static Map<String, Airline> airlines = new HashMap<>();
    private static Map<Route, List<Flight>> flights = new HashMap<>();

    public static void loadAirports() {
        CsvReader reader = new CsvReader("src/test/resources/airports.csv");
        List<String[]> lines = reader.run();

        for (String[] line : lines) {
            airports.put(line[0], new Airport(line[0], line[1]));
        }
    }

    public static void loadAirlines() {
        CsvReader reader = new CsvReader("src/test/resources/airlines.csv");
        List<String[]> lines = reader.run();

        for (String[] line : lines) {
            airlines.put(line[0], new Airline(line[0], line[1], Float.valueOf(line[2])));
        }
    }

    public static void loadFlights() {
        CsvReader csvReader = new CsvReader("src/test/resources/flights.csv");
        List<String[]> lines = csvReader.run();

        for (String[] line : lines) {
            Route route = new Route(getAirportByCode(line[0]), getAirportByCode(line[1]));
            Flight newFlight = new Flight(route, line[2], Float.valueOf(line[3]));

            if (flights.containsKey(route)) {
                flights.get(route).add(newFlight);
            } else {
                List<Flight> newFlights = new ArrayList<>();
                newFlights.add(newFlight);
                flights.put(route, newFlights);
            }
        }
    }

    private static Airport getAirportByCode(String code) {
        return airports.get(code);
    }
}
