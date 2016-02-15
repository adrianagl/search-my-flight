package com.flight.search.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CsvReader {

    private static final String COMMA = ",";

    private String csvFilePath;

    public CsvReader(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    public List<String> run() {
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(csvFilePath))) {
            list = stream
                    .collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
