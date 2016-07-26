package ua.com.westwind.project.model.compositiontarins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.com.westwind.project.model.lokomotives.ElectricLocomotive;
import ua.com.westwind.project.model.lokomotives.Locomotives;
import ua.com.westwind.project.model.lokomotives.VaporLocomotive;
import ua.com.westwind.project.model.wagons.freightwagons.CisternFreightWagon;
import ua.com.westwind.project.model.wagons.freightwagons.FreightWagon;
import ua.com.westwind.project.model.wagons.freightwagons.PlatformFreightWagon;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CompositionFreightTrainTest {

    CompositionFreightTrain com;

    @Before
    public void setUp() throws Exception{
        com = new CompositionFreightTrain();
    }

    @Test
    public void getRoute() throws Exception {
        String testS = "test";
        com.setRoute(testS);
        Assert.assertTrue(com.getRoute().equals(testS));
    }

    @Test
    public void setRoute() throws Exception {
        String testS = "test";
        com.setRoute(testS);
        Assert.assertTrue(com.getRoute().equals(testS));
    }

    @Test
    public void getListLocomotives() throws Exception {
        ArrayList<Locomotives> list = new ArrayList<>();
        Assert.assertNull(com.getListLocomotives());
        list.add(new ElectricLocomotive());
        list.add(new VaporLocomotive());
        com.setListLocomotives(list);
        Assert.assertNotNull(com.getListLocomotives());
    }

    @Test
    public void setListLocomotives() throws Exception {
        ArrayList<Locomotives> list = new ArrayList<>();
        Assert.assertNull(com.getListLocomotives());
        list.add(new ElectricLocomotive());
        list.add(new VaporLocomotive());
        com.setListLocomotives(list);
        Assert.assertNotNull(com.getListLocomotives());
    }

    @Test
    public void getListWagons() throws Exception {
        ArrayList<FreightWagon> list = new ArrayList<>();
        Assert.assertNull(com.getListWagons());
        list.add(new CisternFreightWagon());
        list.add(new PlatformFreightWagon());
        com.setListWagons(list);
        Assert.assertNotNull(com.getListWagons());
    }

    @Test
    public void setListWagons() throws Exception {
        ArrayList<FreightWagon> list = new ArrayList<>();
        Assert.assertNull(com.getListWagons());
        list.add(new CisternFreightWagon());
        list.add(new PlatformFreightWagon());
        com.setListWagons(list);
        Assert.assertNotNull(com.getListWagons());
    }

    @Test
    public void getTypeTrain() throws Exception {
        Assert.assertTrue(com.getTypeTrain().equals("CompositionFreightTrain"));
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertNotNull(com.toString());
        Assert.assertTrue(com.toString().getClass()==String.class);
    }

    @Test
    public void testEquals() throws Exception {
        CompositionPassengerTrain helpP = new CompositionPassengerTrain();
        Assert.assertFalse(com.equals(helpP));

        ArrayList<Locomotives> listL = new ArrayList<>();
        listL.add(new ElectricLocomotive());
        listL.add(new VaporLocomotive());
        ArrayList<FreightWagon> listW = new ArrayList<>();
        listW.add(new CisternFreightWagon());
        listW.add(new PlatformFreightWagon());
        CompositionFreightTrain helpF = new CompositionFreightTrain(listL,listW);

        Assert.assertFalse(com.equals(helpF));

        Assert.assertTrue(com.equals(com));
    }

    @Test
    public void testHashCode() throws Exception {
        ArrayList<Locomotives> listL = new ArrayList<>();
        listL.add(new ElectricLocomotive());
        listL.add(new VaporLocomotive());
        ArrayList<FreightWagon> listW = new ArrayList<>();
        listW.add(new CisternFreightWagon());
        listW.add(new PlatformFreightWagon());
        CompositionFreightTrain helpF = new CompositionFreightTrain(listL,listW);

        Assert.assertFalse(com.hashCode() == helpF.hashCode());

        com = new CompositionFreightTrain(listL,listW);

        Assert.assertTrue(com.hashCode() == helpF.hashCode());
    }

}