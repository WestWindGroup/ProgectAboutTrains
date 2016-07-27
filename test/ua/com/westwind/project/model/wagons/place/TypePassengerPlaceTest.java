package ua.com.westwind.project.model.wagons.place;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TypePassengerPlaceTest {
    @Test
    public void getFeaturesPlace() throws Exception {

        int seatP = 0;
        int downP = 1;
        int upP = 2;
        int sidePlUp = 3;
        int sidePlDw = 4;

        int num = TypePassengerPlace.SEAT_PLACE.getFeaturesPlace();
        Assert.assertTrue(num == seatP);
        num = TypePassengerPlace.DOWN_PLACE.getFeaturesPlace();
        Assert.assertTrue(num == downP);
        num = TypePassengerPlace.UP_PLACE.getFeaturesPlace();
        Assert.assertTrue(num == upP);
        num = TypePassengerPlace.SIDE_PLACE_UP.getFeaturesPlace();
        Assert.assertTrue(num == sidePlUp);
        num = TypePassengerPlace.SIDE_PLACE_DOWN.getFeaturesPlace();
        Assert.assertTrue(num == sidePlDw);
    }

}