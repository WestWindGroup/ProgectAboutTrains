package ua.com.westwind.project.model.trainfactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.com.westwind.project.model.passenger.Passenger;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RandomFillPassengersTrainTest {

    RandomFillPassengersTrain randomFillPassengersTrain;
    private double maxMassBaggage;

    @Before
    public void setUp() throws Exception {
        randomFillPassengersTrain = new RandomFillPassengersTrain();
        maxMassBaggage = 36;
    }

    @Test
    public void fillPassengers1() throws Exception {
        String route = "test";
        ArrayList<PassengerWagon> listWagons = null;
        ArrayList<Passenger> listPassengers;
        listPassengers = randomFillPassengersTrain.fillPassengers(route,listWagons);
        Assert.assertTrue(listPassengers.size() == 0);
    }

    @Test
    public void fillPassengers2() throws Exception {
        String route = null;
        ArrayList<PassengerWagon> listWagons = null;
        ArrayList<Passenger> listPassengers;
        listPassengers = randomFillPassengersTrain.fillPassengers(route,listWagons);
        Assert.assertTrue(listPassengers.size() == 0);
    }

    @Test
    public void fillPassengers3() throws Exception {
        String route = "";
        ArrayList<PassengerWagon> listWagons = null;
        ArrayList<Passenger> listPassengers;
        listPassengers = randomFillPassengersTrain.fillPassengers(route,listWagons);
        Assert.assertTrue(listPassengers.size() == 0);
    }

    @Test
    public void fillPassengers4() throws Exception {
        String route = "test";
        ArrayList<PassengerWagon> listWagons = new ArrayList<>();
        ArrayList<Passenger> listPassengers;
        listPassengers = randomFillPassengersTrain.fillPassengers(route,listWagons);
        Assert.assertTrue(listPassengers.size() == 0);
    }

    @Test
    public void getMaxMassBaggage() throws Exception {
        Assert.assertTrue(randomFillPassengersTrain.getMaxMassBaggage() == maxMassBaggage);
    }

    @Test
    public void setMaxMassBaggage() throws Exception {
        double newMaxMassBaggage = 22;
        randomFillPassengersTrain.setMaxMassBaggage(newMaxMassBaggage);
        Assert.assertTrue(randomFillPassengersTrain.getMaxMassBaggage() == newMaxMassBaggage);
    }

}