package ua.com.westwind.project.model.wagons.passengerwagons;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntercityWagonTest {

    @Test
    public void getCountPlaceFirstClass() throws Exception {
        int oneClass = 40;
        int twoClass = 0;
        IntercityWagon intercityWagon = new IntercityWagon(IntercityTypeWagon.WAGON_1_CLASS,oneClass,twoClass);
        Assert.assertTrue(intercityWagon.getCountPlaceFirstClass() == oneClass);
    }

    @Test
    public void getCountPlaceSecondClass() throws Exception {
        int oneClass = 0;
        int twoClass = 55;
        IntercityWagon intercityWagon = new IntercityWagon(IntercityTypeWagon.WAGON_1_CLASS,oneClass,twoClass);
        Assert.assertTrue(intercityWagon.getCountPlaceSecondClass() == twoClass);
    }

}