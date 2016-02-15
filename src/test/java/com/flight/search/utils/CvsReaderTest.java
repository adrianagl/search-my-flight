package com.flight.search.utils;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CvsReaderTest {

    @Test
    public void run() {
        String csvFilePath = getCsvFilePath("test_csv_file.csv");
        CsvReader reader = new CsvReader(csvFilePath);

        List<String> lines = reader.run();

        assertEquals(2, lines.size());
        assertEquals(lines.get(0), "MAD,IST,IB2818,186");
        assertEquals(lines.get(1), "CPH,LHR,U23631,152");

    }

    private String getCsvFilePath(String csvFilename) {
        return getClass().getClassLoader().getResource(csvFilename).getFile();
    }
}
