package com.flight.search.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.flight.search.model.Flight;

public class FlightCsvReader {

    private static final String COMMA = ",";

    private String csvFilePath;

    public FlightCsvReader(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    public List<Flight> run() {
        List<Flight> flights = new ArrayList<>();
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csvFilePath));

            br.readLine();

            while((line = br.readLine()) != null) {
                String[] flight = line.split(COMMA);
                flights.add(Flight.build(flight));
            }
        } catch (FileNotFoundException exc) {
            throw new RuntimeException("The file was not found", exc);
        } catch (IOException exc) {
            throw new RuntimeException("An error has occurred while reading the csv file", exc);
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException exc) {
                    throw new RuntimeException("An error has occurred while closing the file", exc);
                }
            }
        }

        return flights;
    }
}
