package ua.com.westwind.project.model.wagons.passengerwagons;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.com.westwind.project.model.wagons.place.Place;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PassengerWagonTest {

    PassengerWagon passengerWagon;

    @Before
    public void setUp() throws Exception {
        passengerWagon = new CoupeNormalWagon();

    }

    @Test
    public void getAllMassBaggege() throws Exception {
        Assert.assertTrue(passengerWagon.getAllMassBaggege() == 0);
    }

    @Test
    public void setAllMassBaggege() throws Exception {
        double massBagg = 3897.0;
        passengerWagon.setAllMassBaggege(massBagg);

        Assert.assertTrue(passengerWagon.getAllMassBaggege() == massBagg);
    }

    @Test
    public void getCountBusyPlace() throws Exception {
        Assert.assertTrue(passengerWagon.getCountBusyPlace() == 0);
    }

    @Test
    public void setCountBusyPlace() throws Exception {
        int countBusy = 389;
        passengerWagon.setCountBusyPlace(countBusy);

        Assert.assertTrue(passengerWagon.getCountBusyPlace() == countBusy);
    }

    @Test
    public void getPassengerTypeWagon() throws Exception {
        Assert.assertTrue(passengerWagon.getPassengerTypeWagon() == PassengerTypeWagon.COUPE);
    }

    @Test
    public void getCountPlace() throws Exception {
        int countP = 40;
        Assert.assertTrue(passengerWagon.getCountPlace() == countP);
    }

    @Test
    public void getListPlace() throws Exception {
        int countP = 40;
        ArrayList<Place> places = new ArrayList<>();
        places = passengerWagon.getListPlace();
        Assert.assertTrue(places.size() == countP);
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertNotNull(passengerWagon.toString());
        Assert.assertTrue(passengerWagon.toString().getClass()==String.class);
    }

    @Test
    public void compareTo() throws Exception {
        PassengerWagon passengerWagon1 = new CoupeNormalWagon();
        Assert.assertTrue(passengerWagon1.compareTo(passengerWagon) == 0);
        passengerWagon1 = new EconomPassengerWagon();
        Assert.assertTrue(passengerWagon1.compareTo(passengerWagon) > 0);
    }

    @Test
    public void equals() throws Exception {
        PassengerWagon passengerWagon1 = new CoupeNormalWagon();
        Assert.assertTrue(passengerWagon1.equals(passengerWagon));
        passengerWagon1 = new EconomPassengerWagon();
        Assert.assertFalse(passengerWagon1.equals(passengerWagon));
    }

    @Test
    public void testHashCode() throws Exception {
        PassengerWagon passengerWagon1 = new CoupeNormalWagon();
        Assert.assertTrue(passengerWagon1.hashCode() == passengerWagon.hashCode());
        passengerWagon1 = new EconomPassengerWagon();
        Assert.assertFalse(passengerWagon1.equals(passengerWagon));
    }

}