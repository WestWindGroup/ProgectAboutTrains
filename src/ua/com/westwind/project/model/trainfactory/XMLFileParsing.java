package ua.com.westwind.project.model.trainfactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import ua.com.westwind.project.model.Locomotives;
import ua.com.westwind.project.model.Train;
import ua.com.westwind.project.model.compositiontarins.CompositionPassengerTrain;
import ua.com.westwind.project.model.compositiontarins.Passenger;
import ua.com.westwind.project.model.intercity.HyundaiIntercityTrains;
import ua.com.westwind.project.model.intercity.SkodaIntercityTrains;
import ua.com.westwind.project.model.intercity.TarpanIntercityTrains;
import ua.com.westwind.project.model.intercity.TrainLocomotiveTraction;
import ua.com.westwind.project.model.lokomotives.ElectricLocomotive;
import ua.com.westwind.project.model.lokomotives.GasTurbinesLocomotive;
import ua.com.westwind.project.model.lokomotives.HeatLocomotive;
import ua.com.westwind.project.model.lokomotives.VaporLocomotive;
import ua.com.westwind.project.model.wagons.passengerwagons.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;


public class XMLFileParsing {
    public static Train readXMLfileIntercity(String nameFile){

        final String PATH = nameFile;

        File input = new File(PATH);

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(input);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++){
                if(nodeList.item(i).getNodeName().equals("intercityTrain")){
                    NamedNodeMap nodeMap = nodeList.item(i).getAttributes();
                    for (int j = 0; j < nodeMap.getLength(); j ++){
                        if(nodeMap.item(j).getNodeName().equals("name")){
                            String help = nodeMap.item(j).getNodeValue();
                            if(help.equals("Hyundai")){
                                return new HyundaiIntercityTrains();
                            }else if(help.equals("Skoda")){
                                return new SkodaIntercityTrains();
                            }else if(help.equals("Tarpan")){
                                return new TarpanIntercityTrains();
                            }else if(help.equals("LocomotiveTraction")){
                                return new TrainLocomotiveTraction();
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static CompositionPassengerTrain readXMLfileComposition(String nameFile){
        ArrayList<Locomotives> listL = new ArrayList<>();
        ArrayList<PassengerWagon> listW = new ArrayList<>();
        ArrayList<Passenger> listP;

        final String PATH = nameFile;

        File input = new File(PATH);

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(input);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++){
                if(nodeList.item(i).getNodeName().equals("locomotive")){
                    NamedNodeMap nodeMap = nodeList.item(i).getAttributes();
                    int count = 0;
                    for (int j = 0; j < nodeMap.getLength(); j ++){
                        if(nodeMap.item(j).getNodeName().equals("count")){
                            count = Integer.parseInt(nodeMap.item(j).getNodeValue());
                        }
                        if(nodeMap.item(j).getNodeName().equals("type")){
                            for (int k = 0; k < count; k++) {
                                listL.add(createLocomotive(nodeMap.item(j).getNodeValue()));
                            }
                        }
                    }
                }
                if(nodeList.item(i).getNodeName().equals("wagon")){
                    NamedNodeMap nodeMap = nodeList.item(i).getAttributes();
                    int count = 0;
                    for (int j = 0; j < nodeMap.getLength(); j ++){
                        if(nodeMap.item(j).getNodeName().equals("count")){
                            count = Integer.parseInt(nodeMap.item(j).getNodeValue());
                        }
                        if(nodeMap.item(j).getNodeName().equals("type")){
                            for (int k = 0; k < count; k++) {
                                listW.add(createWagon(nodeMap.item(j).getNodeValue()));
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RandomFillPassengerTrain randomFillPassengerTrain = new RandomFillPassengerTrain();

        listP = randomFillPassengerTrain.fillPassengers(listW);

        return new CompositionPassengerTrain(listL,listW,listP);
    }
    private static Locomotives createLocomotive(String type){

        if(type.equals("ElectricLocomotive")){
            return new ElectricLocomotive();
        }else if(type.equals("GasTurbinesLocomotive")){
            return new GasTurbinesLocomotive();
        }else if(type.equals("HeatLocomotive")){
            return new HeatLocomotive();
        }else if(type.equals("VaporLocomotive")){
            return new VaporLocomotive();
        }
        return null;
    }

    private static PassengerWagon createWagon(String type){

        if(type.equals("CoupeSVWagon")){
            return new CoupeSVWagon();
        }else if(type.equals("CoupeNormalWagon")){
            return new CoupeNormalWagon();
        }else if(type.equals("EconomPassengerWagon")){
            return new EconomPassengerWagon();
        }else if(type.equals("PassengerWagonWithSeating")){
            return new PassengerWagonWithSeating();
        }else if(type.equals("CoupeWagonWithSeating")){
            return new CoupeWagonWithSeating();
        }
        return null;
    }
}
