package es.ull.passengers;


import es.ull.flights.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestPassenger {

    private Passenger passenger;
    private Passenger passenger2;
    private Passenger passenger3;

    @BeforeEach
    void init(){
        passenger = new Passenger("007","James", "EN");
        passenger2 = new Passenger("001","David", "ES");
        passenger3 = new Passenger("002","Elena", "ES");
    }

    @Test
    void assertGetIdentifier(){
        assertAll("Chek IDs",
                () -> assertEquals("007",passenger.getIdentifier()),
                () -> assertEquals("001",passenger2.getIdentifier()),
                () -> assertEquals("002",passenger3.getIdentifier())
        );
    }

    @Test
    void assertGetName(){
        assertAll("Chek Names",
                () -> assertEquals("James",passenger.getName()),
                () -> assertEquals("David",passenger2.getName()),
                () -> assertEquals("Elena",passenger3.getName())
        );
    }

    @Test
    void assertGetCountryCode(){
        assertAll("Chek Countries",
                () -> assertEquals("EN",passenger.getCountryCode()),
                () -> assertEquals("ES",passenger2.getCountryCode()),
                () -> assertEquals("ES",passenger3.getCountryCode())
        );
    }

    @Test
    void assertGetFlight(){
        Flight flight = new Flight("BOING 747",467);
        passenger.setFlight(flight);
        passenger2.setFlight(flight);
        passenger3.setFlight(flight);
        assertAll("Chek Get Flights",
                () -> assertEquals(flight,passenger.getFlight()),
                () -> assertEquals(flight,passenger2.getFlight()),
                () -> assertEquals(flight,passenger3.getFlight())
        );
    }
}