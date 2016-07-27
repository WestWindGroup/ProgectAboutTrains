package ua.com.westwind.project.model.trainfactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.com.westwind.project.model.passenger.Passenger;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;
import ua.com.westwind.project.model.wagons.place.Place;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class TrainDataProcessingTest {

    TrainDataProcessing trainDataProcessing;
    String routeP;
    String typeTrainP;
    int countWagonP;

    String routeF;
    String typeTrainF;
    int countWagonF;

    String routeIntercity;
    String typeTrainIntercity;
    int countWagonIntercity;
    String nameIntercity;


    @Before
    public void setUp() throws Exception {
        countWagonP = 18;
        routeP = "Lviv-Kremenchuk";
        typeTrainP = "CompositionPassengerTrain";

        countWagonF = 15;
        routeF = "Lviv-Dnepr";
        typeTrainF = "CompositionFreightTrain";

        countWagonIntercity = 9;
        routeIntercity = "Lviv-Kiev";
        nameIntercity = "Tarpan";
        typeTrainIntercity = "IntercityTrain" + " " + nameIntercity;


        trainDataProcessing = new TrainDataProcessing();
    }

    @Test
    public void routePassengerTrainInObjectTrain() throws Exception {
        PassengerTrain passengerTrain = trainDataProcessing.routePassengerTrainInObjectTrain(routeP);
        Assert.assertTrue(passengerTrain.getRoute().equals(routeP));
        Assert.assertTrue(passengerTrain.getTypeTrain().equals(typeTrainP));
        Assert.assertTrue(passengerTrain.getListWagons().size() == countWagonP);

        PassengerTrain passengerTrain1 = trainDataProcessing.routePassengerTrainInObjectTrain(routeIntercity);
        Assert.assertTrue(passengerTrain1.getRoute().equals(routeIntercity));
        Assert.assertTrue(passengerTrain1.getTypeTrain().equals(typeTrainIntercity));
        Assert.assertTrue(passengerTrain1.getListWagons().size() == countWagonIntercity);
    }

    @Test
    public void routeFreightTrainInObjectTrain() throws Exception {
        FreightTrain freightTrain = trainDataProcessing.routeFreightTrainInObjectTrain(routeF);
        Assert.assertTrue(freightTrain.getRoute().equals(routeF));
        Assert.assertTrue(freightTrain.getTypeTrain().equals(typeTrainF));
        Assert.assertTrue(freightTrain.getListWagons().size() == countWagonF);
    }

    @Test
    public void countBusyPlacesInTrain() throws Exception {
        PassengerTrain passengerTrain = trainDataProcessing.routePassengerTrainInObjectTrain(routeP);
        int returnCountBasyPlace = trainDataProcessing.countBusyPlacesInTrain(passengerTrain);
        int testCountBasyPlace = 0;
        for (PassengerWagon wagon:passengerTrain.getListWagons()) {
            for (Place place:wagon.getListPlace()) {
                if(place.isBusy()){
                    testCountBasyPlace++;
                }
            }
        }
        Assert.assertTrue(returnCountBasyPlace == testCountBasyPlace);
    }

    @Test
    public void countAllMassBaggegeInTrain() throws Exception {
        PassengerTrain passengerTrain = trainDataProcessing.routePassengerTrainInObjectTrain(routeP);
        double returnAllMassBaggege = trainDataProcessing.countAllMassBaggegeInTrain(passengerTrain);
        double testAllMassBaggege = 0;
            for (Passenger pass:passengerTrain.getListPassengers()) {
                testAllMassBaggege = testAllMassBaggege + pass.getBaggage().getMassBaggage();
            }
        Assert.assertTrue(((returnAllMassBaggege - testAllMassBaggege) <= 0.1) &&
                (returnAllMassBaggege - testAllMassBaggege) >= -0.1  );
    }

    @Test
    public void searchWagonByCountPassengers() throws Exception {
        PassengerTrain passengerTrain = trainDataProcessing.routePassengerTrainInObjectTrain(routeP);
        Random random = new Random();
        int testCycle = 1000_000;
        int countTesting = 0;
        int maxRandomCountPassenger = 100;

        for (int i = 0; i < testCycle; i++) {
            int minCountPassenger = random.nextInt(maxRandomCountPassenger);
            int maxCountPassenger = minCountPassenger + random.nextInt(maxRandomCountPassenger - minCountPassenger);
            ArrayList<PassengerWagon> returnList =
                    trainDataProcessing.searchWagonByCountPassengers(passengerTrain,minCountPassenger,maxCountPassenger);
            ArrayList<PassengerWagon> testList = new ArrayList<>();

            for (PassengerWagon passW:passengerTrain.getListWagons()) {
                if((passW.getCountBusyPlace() >= minCountPassenger)&&(passW.getCountBusyPlace() <= maxCountPassenger)){
                    testList.add(passW);
                }
            }
            if(testList.size() == 0){
                testList = null;
            }

            if((returnList != null)&&(testList != null)){
                Assert.assertTrue(returnList.size() == testList.size());
                Assert.assertTrue(returnList.equals(testList));
                countTesting++;
            }else if((returnList == null)&&(testList == null)){
                countTesting++;
            }

        }
        Assert.assertTrue(testCycle == countTesting);

    }

}