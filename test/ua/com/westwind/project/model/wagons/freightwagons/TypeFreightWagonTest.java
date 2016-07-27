package ua.com.westwind.project.model.wagons.freightwagons;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TypeFreightWagonTest {
    @Test
    public void getNumberType() throws Exception {
        int cistern = 0;
        int coverred = 1;
        int isothermal = 2;
        int platform = 3;
        int num = TypeFreightWagon.CISTERN.getNumberType();
        Assert.assertTrue(num == cistern);
        num = TypeFreightWagon.COVERRED.getNumberType();
        Assert.assertTrue(num == coverred);
        num = TypeFreightWagon.ISOTHERMAL.getNumberType();
        Assert.assertTrue(num == isothermal);
        num = TypeFreightWagon.PLATFORM.getNumberType();
        Assert.assertTrue(num == platform);
    }

}