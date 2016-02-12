package com.flight.search.utils;

import java.util.List;

import org.junit.Test;

import com.flight.search.model.Airport;
import com.flight.search.model.Flight;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlightCvsReaderTest {

    @Test
    public void run() {
        String csvFilePath = getCsvFilePath("flights_small_test.csv");
        FlightCsvReader reader = new FlightCsvReader(csvFilePath);

        List<Flight> availableFlights = reader.run();

        assertTrue(availableFlights.size() == 2);

        Flight flight1 = availableFlights.get(0);
        assertEquals(Airport.MAD, flight1.getOrigin());
        assertEquals(Airport.IST, flight1.getDestination());
        assertEquals("IB2818", flight1.getFlightNumber());
        assertTrue(186 == flight1.getPrice());

        Flight flight2 = availableFlights.get(1);
        assertEquals(Airport.CPH, flight2.getOrigin());
        assertEquals(Airport.LHR, flight2.getDestination());
        assertEquals("U23631", flight2.getFlightNumber());
        assertTrue(152 == flight2.getPrice());
    }

    private String getCsvFilePath(String csvFilename) {
        return getClass().getClassLoader().getResource(csvFilename).getFile();
    }
}
