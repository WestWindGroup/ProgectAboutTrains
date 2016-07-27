package ua.com.westwind.project.model.wagons.passengerwagons;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassengerTypeWagonTest {
    @Test
    public void getComfortLevel() throws Exception {
        int coupeSv = 0;
        int coupe = 1;
        int econom = 2;
        int coupeSeat = 3;
        int seat = 4;

        int num = PassengerTypeWagon.COUPE_SV.getComfortLevel();
        Assert.assertTrue(num == coupeSv);
        num = PassengerTypeWagon.COUPE.getComfortLevel();
        Assert.assertTrue(num == coupe);
        num = PassengerTypeWagon.ECONOM_PASSENGER_WAGON.getComfortLevel();
        Assert.assertTrue(num == econom);
        num = PassengerTypeWagon.COUPE_WAGON_WITH_SEATING.getComfortLevel();
        Assert.assertTrue(num == coupeSeat);
        num = PassengerTypeWagon.PASSENGER_WAGON_WITH_SEATING.getComfortLevel();
        Assert.assertTrue(num == seat);
    }

}