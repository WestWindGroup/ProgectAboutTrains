package ua.com.westwind.project.model.compositiontarins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.com.westwind.project.model.lokomotives.ElectricLocomotive;
import ua.com.westwind.project.model.lokomotives.GasTurbinesLocomotive;
import ua.com.westwind.project.model.lokomotives.Locomotives;
import ua.com.westwind.project.model.lokomotives.VaporLocomotive;
import ua.com.westwind.project.model.passenger.Passenger;
import ua.com.westwind.project.model.passenger.Ticket;
import ua.com.westwind.project.model.wagons.freightwagons.CisternFreightWagon;
import ua.com.westwind.project.model.wagons.freightwagons.FreightWagon;
import ua.com.westwind.project.model.wagons.freightwagons.PlatformFreightWagon;
import ua.com.westwind.project.model.wagons.passengerwagons.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CompositionPassengerTrainTest {

    CompositionPassengerTrain com;
    ArrayList<PassengerWagon> listW;
    ArrayList<Locomotives> listL;
    ArrayList<Passenger> listP;
    String testS;

    @Before
    public void setUp() throws Exception {
        testS = "test";
        listL = new ArrayList<>();
        listL.add(new ElectricLocomotive());
        listL.add(new VaporLocomotive());
        listW = new ArrayList<>();
        listW.add(new CoupeNormalWagon());
        listW.add(new PassengerWagonWithSeating());
        listP = new ArrayList<>();
        listP.add(new Passenger(new Ticket(testS,1,5)));
        com = new CompositionPassengerTrain(testS,listL,listW,listP);
    }

    @Test
    public void getTypeTrain() throws Exception {
        System.out.println(com.getTypeTrain());
        Assert.assertTrue(com.getTypeTrain().equals("CompositionPassengerTrain"));
    }

    @Test
    public void getRoute() throws Exception {
        Assert.assertTrue(com.getRoute().equals(testS));
    }

    @Test
    public void setRoute() throws Exception {
        com.setRoute("test2");
        Assert.assertTrue(com.getRoute().equals("test2"));
    }

    @Test
    public void getListLocomotives() throws Exception {
        Assert.assertNotNull(com.getListLocomotives());
        Assert.assertTrue(com.getListLocomotives().size() == listL.size());
        Assert.assertTrue(com.getListLocomotives().equals(listL));
    }

    @Test
    public void setListLocomotives() throws Exception {
        ArrayList<Locomotives> list = new ArrayList<>();
        list.add(new GasTurbinesLocomotive());
        list.add(new GasTurbinesLocomotive());
        com.setListLocomotives(list);
        Assert.assertFalse(com.getListLocomotives().equals(listL));
    }

    @Test
    public void getListPassengers() throws Exception {
        Assert.assertNotNull(com.getListPassengers());

        Assert.assertTrue(com.getListPassengers().equals(listP));
    }

    @Test
    public void getListWagons() throws Exception {
        Assert.assertNotNull(com.getListWagons());

        Assert.assertTrue(com.getListWagons().equals(listW));
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertNotNull(com.toString());
        Assert.assertTrue(com.toString().getClass()==String.class);
    }

    @Test
    public void equals() throws Exception {
        CompositionFreightTrain helpP = new CompositionFreightTrain();
        Assert.assertFalse(com.equals(helpP));

        ArrayList<Locomotives> helpL = new ArrayList<>();
        helpL.add(new ElectricLocomotive());
        helpL.add(new VaporLocomotive());
        ArrayList<PassengerWagon> helpW = new ArrayList<>();
        helpW.add(new CoupeWagonWithSeating());
        helpW.add(new EconomPassengerWagon());
        CompositionPassengerTrain helpF = new CompositionPassengerTrain(listL,listW);

        Assert.assertFalse(com.equals(helpF));

        Assert.assertTrue(com.equals(com));
    }

    @Test
    public void testHashCode() throws Exception {
        ArrayList<Locomotives> helpL = new ArrayList<>();
        helpL.add(new ElectricLocomotive());
        helpL.add(new VaporLocomotive());
        ArrayList<PassengerWagon> helpW = new ArrayList<>();
        helpW.add(new CoupeWagonWithSeating());
        helpW.add(new EconomPassengerWagon());

        CompositionPassengerTrain helpF = new CompositionPassengerTrain(helpL,helpW);
        Assert.assertFalse(com.hashCode() == helpF.hashCode());

        helpF = new CompositionPassengerTrain(testS,listL,listW,listP);

        Assert.assertTrue(com.hashCode() == helpF.hashCode());
    }

}