package com.flight.search.utils;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.flight.search.model.AirportCombination;
import com.flight.search.model.Airport;
import com.flight.search.model.Flight;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlightCvsReaderTest {

    @Test
    public void run() {
        String csvFilePath = getCsvFilePath("flights_small_test.csv");
        FlightCsvReader reader = new FlightCsvReader(csvFilePath);

        Map<AirportCombination, List<Flight>> availableCombinations = reader.run();

        assertEquals(2, availableCombinations.size());

        List<Flight> madBcnFlights = availableCombinations.get(new AirportCombination(Airport.MAD, Airport.IST));
        assertEquals(2, madBcnFlights.size());
        checkFlightValues(madBcnFlights.get(0), Airport.MAD, Airport.IST, "IB2818", 186);
        checkFlightValues(madBcnFlights.get(1), Airport.MAD, Airport.IST, "IB5262", 195);

        List<Flight> cphLhrFlights = availableCombinations.get(new AirportCombination(Airport.CPH, Airport.LHR));
        assertEquals(1, cphLhrFlights.size());
        checkFlightValues(cphLhrFlights.get(0), Airport.CPH, Airport.LHR, "U23631", 152);
    }

    private String getCsvFilePath(String csvFilename) {
        return getClass().getClassLoader().getResource(csvFilename).getFile();
    }

    private void checkFlightValues(Flight flight, Airport origin, Airport destination, String flightNumber, float price) {
        assertEquals(origin, flight.getOrigin());
        assertEquals(destination, flight.getDestination());
        assertEquals(flightNumber, flight.getFlightNumber());
        assertTrue(price == flight.getPrice());
    }
}
