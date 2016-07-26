package ua.com.westwind.project.model.passenger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassengerTest {
    String testS;
    Ticket ticket;
    Baggage baggage;
    double massB;
    int numWagon;
     int numPlace;
    Passenger passenger;

    @Before
    public void setUp() throws Exception {
        massB = 33.0;
        testS = "test";
        numWagon = 4;
        numPlace = 63;
        ticket = new Ticket(testS,1,5);
        baggage = new Baggage(massB,ticket);
        passenger = new Passenger(ticket,baggage);
    }

    @Test
    public void getTICKET() throws Exception {
        Assert.assertNotNull(passenger.getTICKET());
    }

    @Test
    public void getBaggage() throws Exception {
        Assert.assertNotNull(passenger.getBaggage());
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertNotNull(passenger.toString());
        Assert.assertTrue(passenger.toString().getClass()==String.class);
    }

    @Test
    public void equals() throws Exception {
        Passenger passenger1  = new Passenger(ticket,baggage);
        Assert.assertTrue(passenger.equals(passenger1));
        Passenger passenger2  = new Passenger(ticket);
        Assert.assertFalse(passenger.equals(passenger2));
    }

    @Test
    public void testHashCode() throws Exception {
        Passenger passenger1  = new Passenger(ticket,baggage);
        Assert.assertTrue(passenger.hashCode() == passenger1.hashCode());
        Passenger passenger2  = new Passenger(ticket);
        Assert.assertFalse(passenger.hashCode() == passenger2.hashCode());
    }

}