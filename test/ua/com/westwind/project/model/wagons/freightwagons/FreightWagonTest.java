package ua.com.westwind.project.model.wagons.freightwagons;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FreightWagonTest {
    @Test
    public void getTypeFreightWagon() throws Exception {
        FreightWagon freightWagon = new IsothermalFreightWagon();
        Assert.assertNotNull(freightWagon.getTypeFreightWagon());
    }

}