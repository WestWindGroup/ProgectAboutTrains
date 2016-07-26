package ua.com.westwind.project.model.passenger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicketTest {
    String testS;
    Ticket ticket;
    int numWagon;
    int numPlace;

    @Before
    public void setUp() throws Exception {
        testS = "test";
        numWagon = 4;
        numPlace = 63;
        ticket = new Ticket(testS,numWagon,numPlace);
    }

    @Test
    public void getROUTE() throws Exception {
        Assert.assertTrue(ticket.getROUTE().equals(testS));
    }

    @Test
    public void getNUMBER_WAGON() throws Exception {
        Assert.assertTrue(ticket.getNUMBER_WAGON()== numWagon);
    }

    @Test
    public void getNUMBER_PLACE() throws Exception {
        Assert.assertTrue(ticket.getNUMBER_PLACE()== numPlace);
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertNotNull(ticket.toString());
        Assert.assertTrue(ticket.toString().getClass()==String.class);
    }

    @Test
    public void equals() throws Exception {
        String test = testS + "fff";
        int numW = numWagon + 1;
        int numP = numPlace + 4;
        Ticket ticket1 = new Ticket(testS,numWagon,numPlace);
        Assert.assertTrue(ticket.equals(ticket1));
        Ticket ticket2 = new Ticket(test,numW,numP);
        Assert.assertFalse(ticket.equals(ticket2));
    }

    @Test
    public void testHashCode() throws Exception {
        String test = testS + "fff";
        int numW = numWagon + 1;
        int numP = numPlace + 4;
        Ticket ticket1 = new Ticket(testS,numWagon,numPlace);
        Assert.assertTrue(ticket.hashCode() == ticket1.hashCode());
        Ticket ticket2 = new Ticket(test,numW,numP);
        Assert.assertFalse(ticket.hashCode() == ticket2.hashCode());
    }

}