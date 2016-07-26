package ua.com.westwind.project.model.intercity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntercityTrainTest {

    HyundaiIntercityTrain hyundai;
    String routeTest = "Lviv-Kiev";

    @Before
    public void setUp() throws Exception {
        hyundai = new HyundaiIntercityTrain(routeTest);
    }

    @Test
    public void getTypeTrain() throws Exception {
        Assert.assertTrue(hyundai.getTypeTrain().equals("IntercityTrain" + " " + hyundai.getNameTrain()));
    }

    @Test
    public void getNameTrain() throws Exception {
        Assert.assertTrue(hyundai.getNameTrain().equals("Hyundai"));
    }

    @Test
    public void getCountWagonsAmount() throws Exception {
        int countWagon = 9;
        Assert.assertTrue(hyundai.getCountWagonsAmount() == countWagon);
    }

    @Test
    public void getCountWagonsFirstClass() throws Exception {
        int countWagon = 3;
        Assert.assertTrue(hyundai.getCountWagonsFirstClass() == countWagon);
    }

    @Test
    public void getCountWagonsSecondClass() throws Exception {
        int countWagon = 6;
        Assert.assertTrue(hyundai.getCountWagonsSecondClass() == countWagon);
    }

    @Test
    public void getCountWagonsFirstAndSecondClass() throws Exception {
        int countWagonInHyundaiTrain = 0;
        Assert.assertTrue(hyundai.getCountWagonsFirstAndSecondClass() == countWagonInHyundaiTrain);
    }

    @Test
    public void getRoute() throws Exception {
        Assert.assertTrue(hyundai.getRoute().equals(routeTest));
    }

    @Test
    public void setRoute() throws Exception {
        hyundai.setRoute("test");
        Assert.assertTrue(hyundai.getRoute().equals("test"));
    }

    @Test
    public void getListPassengers() throws Exception {
        Assert.assertNotNull(hyundai.getListPassengers());
        Assert.assertTrue(hyundai.getListPassengers().size() != 0);
    }

    @Test
    public void getListWagons() throws Exception {
        Assert.assertNotNull(hyundai.getListWagons());
        Assert.assertTrue(hyundai.getListWagons().size() != 0);
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertNotNull(hyundai.toString());
        Assert.assertTrue(hyundai.toString().getClass()==String.class);
    }

    @Test
    public void equals() throws Exception {
        IntercityTrain train1 = new SkodaIntercityTrain(routeTest);
        Assert.assertFalse(hyundai.equals(train1));
        IntercityTrain train2 = new HyundaiIntercityTrain(routeTest);
        Assert.assertTrue(hyundai.equals(train2));
    }

    @Test
    public void testHashCode() throws Exception {
        IntercityTrain train1 = new SkodaIntercityTrain(routeTest);
        Assert.assertTrue(hyundai.hashCode() != train1.hashCode());
        IntercityTrain train2 = new HyundaiIntercityTrain(routeTest);
        Assert.assertTrue(hyundai.hashCode() == train2.hashCode());
    }

}