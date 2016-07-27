package ua.com.westwind.project.model.wagons.passengerwagons;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntercityTypeWagonTest {
    @Test
    public void getComfortLevel() throws Exception {
        int oneClass = 0;
        int twoClass = 2;
        int threeClass = 1;
        int num = IntercityTypeWagon.WAGON_1_CLASS.getComfortLevel();
        Assert.assertTrue(num == oneClass);
        num = IntercityTypeWagon.WAGON_2_CLASS.getComfortLevel();
        Assert.assertTrue(num == twoClass);
        num = IntercityTypeWagon.WAGON_1_AND_2_CLASSES.getComfortLevel();
        Assert.assertTrue(num == threeClass);
    }

}