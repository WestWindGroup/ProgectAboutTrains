package ua.com.westwind.project.model.lokomotives;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocomotivesTest {

    Locomotives locomotives;

    @Before
    public void setUp() throws Exception {
        locomotives = new ElectricLocomotive();
    }


    @Test
    public void getNameLocomotive() throws Exception {
        Assert.assertTrue(locomotives.getNameLocomotive().equals("ElectricLocomotive"));
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertNotNull(locomotives.toString());
        Assert.assertTrue(locomotives.toString().getClass()==String.class);
    }

    @Test
    public void equals() throws Exception {
        VaporLocomotive vaporLocomotive = new VaporLocomotive();
        Assert.assertFalse(locomotives.equals(vaporLocomotive));
        ElectricLocomotive electricLocomotive = new ElectricLocomotive();
        Assert.assertTrue(locomotives.equals(electricLocomotive));
    }

    @Test
    public void testHashCode() throws Exception {
        VaporLocomotive vaporLocomotive = new VaporLocomotive();
        Assert.assertFalse(locomotives.hashCode() == vaporLocomotive.hashCode());
        ElectricLocomotive electricLocomotive = new ElectricLocomotive();
        Assert.assertTrue(locomotives.hashCode() == electricLocomotive.hashCode());
    }

}