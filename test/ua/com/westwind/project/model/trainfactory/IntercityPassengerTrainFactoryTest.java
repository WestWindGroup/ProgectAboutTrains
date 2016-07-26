package ua.com.westwind.project.model.trainfactory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntercityPassengerTrainFactoryTest {
    @Test
    public void createTrain1() throws Exception {
        String route = "Lviv-Kiev";
        String nameFile = "resources\\passenger\\Lviv-Kiev.xml";
        PassengerTrain train = XMLFileParsing.readXMLfileCompositionPassengerTrain(route,nameFile);
        Assert.assertNotNull(train);
    }

    @Test(expected = NullPointerException.class)
    public void createTrain2() throws Exception {
        String route = "Odessa-Kharkov";
        String nameFile = "resources\\passenger\\Odessa-Kharkov.xml";
        PassengerTrain train = XMLFileParsing.readXMLfileCompositionPassengerTrain(route,nameFile);
        Assert.assertNotNull(train);
    }
}