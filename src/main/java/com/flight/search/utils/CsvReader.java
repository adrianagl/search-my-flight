package com.flight.search.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    private static final String COMMA = ",";

    private String csvFilePath;

    public CsvReader(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    public List<String[]> run() {
        List<String[]> lines = new ArrayList<>();

        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(csvFilePath));

            while((line = br.readLine()) != null) {
                String[] flight = line.split(COMMA);
                lines.add(flight);
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

        return lines;
    }
}
