package com.flight.search.utils;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CvsReaderTest {

    @Test
    public void run() {
        String csvFilePath = getCsvFilePath("test_csv_file.csv");
        CsvReader reader = new CsvReader(csvFilePath);

        List<String[]> lines = reader.run();

        assertEquals(2, lines.size());
        checkValues(lines.get(0), new String[]{"MAD", "IST", "IB2818", "186"});
        checkValues(lines.get(1), new String[]{"CPH", "LHR", "U23631", "152"});

    }

    private String getCsvFilePath(String csvFilename) {
        return getClass().getClassLoader().getResource(csvFilename).getFile();
    }

    private void checkValues(String[] line, String... values) {
        assertEquals(values.length, line.length);
        for(int i= 0; i < line.length; i++) {
            assertEquals(values[i], line[i]);
        }
    }
}
