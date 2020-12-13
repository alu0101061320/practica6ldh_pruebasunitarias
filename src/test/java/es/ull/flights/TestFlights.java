package es.ull.flights;

import es.ull.passengers.Passenger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestFlights {

    private Flight flight;
    private Passenger passenger;
    private Passenger passenger2;
    private Passenger passenger3;
    boolean throwExceptionInAfterMethod = false;

    @BeforeEach
    void init(){
        flight = new Flight("BO747",467);
        passenger = new Passenger("007","James", "ES");
        passenger2 = new Passenger("001","David", "ES");
        passenger3 = new Passenger("002","Elena", "ES");
        flight.addPassenger(passenger);
        flight.addPassenger(passenger2);
        flight.addPassenger(passenger3);
    }

    @AfterEach
    void after() {
        if (this.throwExceptionInAfterMethod) {
            throw new RuntimeException("Exception thrown from @AfterEach method");
        }
    }


    @Test
    void assertGetFlightNumber(){
        assertEquals("BO747",flight.getFlightNumber());
    }

    @Test
    void assertGetNumberOfPassengers(){
        assertEquals(3,flight.getNumberOfPassengers());
    }

    @Test
    void assertAddPassengers(){
        assertAll("Chek Passengers",
                () -> assertTrue(flight.addPassenger(new Passenger("007", "James", "ES"))),
                () -> assertTrue(flight.addPassenger(new Passenger("001", "David", "ES"))),
                () -> assertTrue(flight.addPassenger(new Passenger("002", "Elena", "ES")))
                );
    }

    @Test
    void assertRemovePassenger(){
        assertTrue(flight.removePassenger(passenger));
    }


}