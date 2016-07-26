package ua.com.westwind.project.model.passenger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaggageTest {

    String testS;
    Ticket ticket;
    Baggage baggage;
    double massB;
    int numWagon;
    int numPlace;

    @Before
    public void setUp() throws Exception {
        numWagon = 4;
        numPlace = 63;
        massB = 33.0;
        testS = "test";
        ticket = new Ticket(testS,numWagon,numPlace);
        baggage = new Baggage(massB,ticket);
    }

    @Test
    public void getMassBaggage() throws Exception {
        Assert.assertTrue(baggage.getMassBaggage() == massB);
    }

    @Test
    public void getROUTE() throws Exception {
        Assert.assertTrue(baggage.getROUTE().equals(testS));
    }

    @Test
    public void getNUMBER_WAGON() throws Exception {
        Assert.assertTrue(baggage.getNUMBER_WAGON()== numWagon);
    }

    @Test
    public void getNUMBER_PLACE() throws Exception {
        Assert.assertTrue(baggage.getNUMBER_PLACE()== numPlace);
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertNotNull(baggage.toString());
        Assert.assertTrue(baggage.toString().getClass()==String.class);
    }

    @Test
    public void equals() throws Exception {
        String test = "test2";
        double mass = 22;
        int numW = 8;
        int numP = 43;
        Ticket ticketN = new Ticket(test,numW,numP);
        Baggage baggage1 = new Baggage(mass,ticketN);
        Assert.assertFalse(baggage.equals(baggage1));
        Baggage baggage2 = new Baggage(massB,ticket);
        Assert.assertTrue(baggage.equals(baggage2));
    }

    @Test
    public void testHashCode() throws Exception {
        String test = "test2";
        double mass = 22;
        int numW = 8;
        int numP = 43;
        Ticket ticketN = new Ticket(test,numW,numP);
        Baggage baggage1 = new Baggage(mass,ticketN);
        Assert.assertFalse(baggage.hashCode() == baggage1.hashCode());
        Baggage baggage2 = new Baggage(massB,ticket);
        Assert.assertTrue(baggage.hashCode() == baggage2.hashCode());
    }

}