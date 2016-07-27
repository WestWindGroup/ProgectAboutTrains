package ua.com.westwind.project.model.wagons.place;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TypeIntercityPlaceTest {
    @Test
    public void getFeaturesPlace() throws Exception {
        int seatP_1class = 1;
        int seatP_2class = 2;

        int num = TypeIntercityPlace.SEAT_PLACE_1_CLASS.getFeaturesPlace();
        Assert.assertTrue(num == seatP_1class);
        num = TypeIntercityPlace.SEAT_PLACE_2_CLASS.getFeaturesPlace();
        Assert.assertTrue(num == seatP_2class);

    }

}