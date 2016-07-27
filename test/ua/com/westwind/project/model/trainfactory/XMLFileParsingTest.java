package ua.com.westwind.project.model.trainfactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class XMLFileParsingTest {

    String path;
    String pathBase;
    String route;
    String nameTrain;
    int countWagonsHyundai;

    @Before
    public void setUp() throws Exception {
        path = "resources\\passenger\\Lviv-Kiev.xml";
        route = "Lviv-Kiev";
        nameTrain = "Hyundai";
        countWagonsHyundai = 9;
        pathBase = "resources\\passenger\\BaseRoutesPassengerTrains.xml";
    }

    @Test
    public void readXMLfileIntercity1() throws Exception {
        PassengerTrain train = XMLFileParsing.readXMLfileIntercity(route,path);
        Assert.assertNotNull(train);
    }

    @Test(expected = RuntimeException.class)
    public void readXMLfileIntercity2() throws Exception {
        PassengerTrain train = XMLFileParsing.readXMLfileIntercity(null,null);
        Assert.assertNull(train);
    }

    @Test(expected = RuntimeException.class)
    public void readXMLfileIntercity3() throws Exception {
        PassengerTrain train = XMLFileParsing.readXMLfileIntercity(null,path);
        Assert.assertNull(train);
    }

    @Test(expected = RuntimeException.class)
    public void readXMLfileIntercity4() throws Exception {
        PassengerTrain train = XMLFileParsing.readXMLfileIntercity("",path);
        Assert.assertNull(train);
    }

    @Test
    public void parsingXMLIntercityTrainInfo1() throws Exception {
        ArrayList<PassengerWagon> list = XMLFileParsing.parsingXMLIntercityTrainInfo(nameTrain);
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() == countWagonsHyundai);
    }

    @Test(expected = RuntimeException.class)
    public void parsingXMLIntercityTrainInfo2() throws Exception {
        ArrayList<PassengerWagon> list = XMLFileParsing.parsingXMLIntercityTrainInfo("test");
    }

    @Test
    public void readXMLfileCompositionPassengerTrain1() throws Exception {
        PassengerTrain train = XMLFileParsing.readXMLfileCompositionPassengerTrain(route,path);
        Assert.assertNotNull(train);
    }

    @Test
    public void readXMLfileCompositionPassengerTrain2() throws Exception {
        PassengerTrain train = XMLFileParsing.readXMLfileCompositionPassengerTrain("test",path);
        Assert.assertNotNull(train);
    }

    @Test(expected = RuntimeException.class)
    public void readXMLfileCompositionPassengerTrain3() throws Exception {
        PassengerTrain train = XMLFileParsing.readXMLfileCompositionPassengerTrain("test","test");
    }

    @Test
    public void readXMLfileCompositionFreightTrain1() throws Exception {
        FreightTrain train = XMLFileParsing.readXMLfileCompositionFreightTrain(route,path);
        Assert.assertNotNull(train);
    }

    @Test
    public void readXMLfileCompositionFreightTrain2() throws Exception {
        FreightTrain train = XMLFileParsing.readXMLfileCompositionFreightTrain("test",path);
        Assert.assertNotNull(train);
    }

    @Test(expected = RuntimeException.class)
    public void readXMLfileCompositionFreightTrain3() throws Exception {
        FreightTrain train = XMLFileParsing.readXMLfileCompositionFreightTrain("test","test");
    }

    @Test
    public void returnDataAboutTrain1() throws Exception {
        String str = XMLFileParsing.returnDataAboutTrain(route, pathBase,"typeTrain");
        Assert.assertNotNull(str);
    }

    @Test
    public void returnDataAboutTrain2() throws Exception {
        String str = XMLFileParsing.returnDataAboutTrain(route, pathBase,"type");
        Assert.assertNull(str);
    }

    @Test(expected = RuntimeException.class)
    public void returnDataAboutTrain3() throws Exception {
        String str = XMLFileParsing.returnDataAboutTrain(route, "test","typeTrain");
    }

}