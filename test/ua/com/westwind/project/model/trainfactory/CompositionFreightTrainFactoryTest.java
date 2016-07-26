package ua.com.westwind.project.model.trainfactory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompositionFreightTrainFactoryTest {
    @Test
    public void createTrain1() throws Exception {
        String nameFile = "resources\\freight\\Lviv-Dnepr.xml";
        FreightTrain train = XMLFileParsing.readXMLfileCompositionFreightTrain(nameFile);
        Assert.assertNotNull(train);
    }

    @Test(expected = NullPointerException.class)
    public void createTrain2() throws Exception {
        String nameFile = "resources\\freight\\Odessa-Kharkov.xml";
        FreightTrain train = XMLFileParsing.readXMLfileCompositionFreightTrain(nameFile);
        Assert.assertNotNull(train);
    }

}