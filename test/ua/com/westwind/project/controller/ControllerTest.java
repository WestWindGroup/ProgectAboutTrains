package ua.com.westwind.project.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.com.westwind.project.model.intercity.HyundaiIntercityTrain;
import ua.com.westwind.project.model.intercity.IntercityTrain;
import ua.com.westwind.project.model.trainfactory.PassengerTrain;

import static org.junit.Assert.*;

public class ControllerTest {
    Controller controller;
    String route;

    @Before
    public void setUp() throws Exception {
        route = "Lviv-Dnepr";
        controller = new Controller();
    }

    @Test
    public void getMapCreatePassengerTrains() throws Exception {
        Assert.assertNotNull(controller.getMapCreatePassengerTrains());
    }

    @Test
    public void createPassengerTrainFromBase() throws Exception {
        controller.createPassengerTrainFromBase(route);
        Assert.assertTrue(controller.getMapCreatePassengerTrains().size() == 1);
    }

    @Test
    public void getInPassengerTrainAllMassBaggege() throws Exception {

    }

    @Test
    public void getTrain() throws Exception {
        PassengerTrain train = new HyundaiIntercityTrain();
        controller.setTrain(train);
        Assert.assertTrue(train.hashCode() == controller.getTrain().hashCode());
    }

    @Test
    public void setTrain() throws Exception {
        PassengerTrain train = new HyundaiIntercityTrain();
        controller.setTrain(train);
        Assert.assertTrue(train.hashCode() == controller.getTrain().hashCode());
    }

    @Test
    public void getScanner() throws Exception {
        Assert.assertNotNull(controller.getScanner());
    }

}