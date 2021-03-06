package ua.com.westwind.project.model.trainfactory;

import org.w3c.dom.*;
import ua.com.westwind.project.model.compositiontarins.CompositionFreightTrain;
import ua.com.westwind.project.model.intercity.*;
import ua.com.westwind.project.model.lokomotives.Locomotives;
import ua.com.westwind.project.model.compositiontarins.CompositionPassengerTrain;
import ua.com.westwind.project.model.passenger.Passenger;
import ua.com.westwind.project.model.lokomotives.ElectricLocomotive;
import ua.com.westwind.project.model.lokomotives.GasTurbinesLocomotive;
import ua.com.westwind.project.model.lokomotives.HeatLocomotive;
import ua.com.westwind.project.model.lokomotives.VaporLocomotive;
import ua.com.westwind.project.model.wagons.freightwagons.*;
import ua.com.westwind.project.model.wagons.passengerwagons.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;


public class XMLFileParsing {


    public static PassengerTrain readXMLfileIntercity(String routeTrain, String pathToFileRoute) throws Exception {

        try {
            if (routeTrain == null || routeTrain == "") {
                throw new IllegalArgumentException();
            }
            NodeList nodeList = createNodeList(pathToFileRoute);
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeName().equals("intercityTrain")) {
                    NamedNodeMap nodeMap = nodeList.item(i).getAttributes();
                    for (int j = 0; j < nodeMap.getLength(); j++) {
                        if (nodeMap.item(j).getNodeName().equals("name")) {
                            String help = nodeMap.item(j).getNodeValue();
                            if (help.equals("Hyundai")) {
                                return new HyundaiIntercityTrain(routeTrain);
                            } else if (help.equals("Skoda")) {
                                return new SkodaIntercityTrain(routeTrain);
                            } else if (help.equals("Tarpan")) {
                                return new TarpanIntercityTrain(routeTrain);
                            } else if (help.equals("LocomotiveTraction")) {
                                return new TrainLocomotiveTraction(routeTrain);
                            }
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("В базе данных нет информации об этом поезде ");
            throw new NullPointerException();
        } catch (IllegalArgumentException e) {
            System.out.println("Не правильно указан маршрут");
            throw new IllegalArgumentException();
        }

        return null;
    }

    public static ArrayList<PassengerWagon> parsingXMLIntercityTrainInfo(String nameTrainIntercity) throws Exception {

        final String PATH = "resources\\passenger\\IntercityTrainInfo.xml";
        ArrayList<PassengerWagon> listInterCityWagon = new ArrayList<>();

        NodeList nodeList = createNodeList(PATH);
        try {
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeName().equals(nameTrainIntercity)) {
                    NodeList nodeListElement = nodeList.item(i).getChildNodes();
                    for (int j = 0; j < nodeListElement.getLength(); j++) {
                        if (nodeListElement.item(j).getNodeName().equals("#text")) {
                            continue;
                        }
                        IntercityWagon intercityWagon = parsingElement(nodeListElement.item(j));
                        listInterCityWagon.add(intercityWagon);
                    }
                    return listInterCityWagon;
                }
            }
            throw new IllegalArgumentException();
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("В базе данных нет информации об этом поезде ");
            throw new NullPointerException();
        }
    }

    private static IntercityWagon parsingElement(Node node) {
        IntercityTypeWagon typeWagon = null;
        int countPlaceFirstClass = 0;
        int countPlaceSecondClass = 0;
        NamedNodeMap nodeMap = node.getAttributes();
        if (nodeMap != null) {
            for (int i = 0; i < nodeMap.getLength(); i++) {
                if (nodeMap.item(i).getNodeName().equals("type")) {
                    typeWagon = IntercityTypeWagon.valueOf(nodeMap.item(i).getNodeValue());
                    continue;
                }
                if (nodeMap.item(i).getNodeName().equals("countPlace1")) {
                    countPlaceFirstClass = Integer.parseInt(nodeMap.item(i).getNodeValue());
                    continue;
                }
                if (nodeMap.item(i).getNodeName().equals("countPlace2")) {
                    countPlaceSecondClass = Integer.parseInt(nodeMap.item(i).getNodeValue());
                    continue;
                }
            }
        }
        return new IntercityWagon(typeWagon, countPlaceFirstClass, countPlaceSecondClass);
    }

    public static CompositionPassengerTrain readXMLfileCompositionPassengerTrain(String routeTrain, String nameFile) throws Exception {
        try {
            if (routeTrain == null || routeTrain == "") {
                throw new IllegalArgumentException();
            }
            ArrayList<Locomotives> listL = new ArrayList<>();
            ArrayList<PassengerWagon> listW = new ArrayList<>();
            ArrayList<Passenger> listP;
            NodeList nodeList = createNodeList(nameFile);

            readXMLfileLocomotive(listL, nodeList);
            readXMLfilePassengerWagon(listW, nodeList);


            RandomFillPassengersTrain randomFillPassengersTrain = new RandomFillPassengersTrain();
            listP = randomFillPassengersTrain.fillPassengers(routeTrain, listW);
            return new CompositionPassengerTrain(routeTrain, listL, listW, listP);
        } catch (NullPointerException e) {
            System.out.println("Список вагонов и локомотивов не был получен");
            throw new NullPointerException();
        } catch (IllegalArgumentException e) {
            System.out.println("Не верно указан маршрут поезда");
            throw new IllegalArgumentException();
        }
    }

    public static CompositionFreightTrain readXMLfileCompositionFreightTrain(String routeTrain, String nameFile) throws Exception {
        try {
            if (routeTrain == null || routeTrain == "") {
                throw new IllegalArgumentException();
            }
            ArrayList<Locomotives> listL = new ArrayList<>();
            ArrayList<FreightWagon> listW = new ArrayList<>();
            NodeList nodeList = createNodeList(nameFile);

            readXMLfileLocomotive(listL, nodeList);
            readXMLfileFreightWagon(listW, nodeList);

            return new CompositionFreightTrain(routeTrain, listL, listW);

        } catch (NullPointerException e) {
            System.out.println("Список вагонов и локомотивов не был получен");
            throw new NullPointerException();
        } catch (IllegalArgumentException e) {
            System.out.println("Не верно указан маршрут поезда");
            throw new IllegalArgumentException();
        }
    }

    private static void readXMLfileLocomotive(ArrayList<Locomotives> list, NodeList nodeList) throws Exception {

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals("locomotive")) {
                NamedNodeMap nodeMap = nodeList.item(i).getAttributes();
                int count = 0;
                for (int j = 0; j < nodeMap.getLength(); j++) {
                    if (nodeMap.item(j).getNodeName().equals("count")) {
                        count = Integer.parseInt(nodeMap.item(j).getNodeValue());
                    }
                    if (nodeMap.item(j).getNodeName().equals("type")) {
                        for (int k = 0; k < count; k++) {
                            list.add(createLocomotive(nodeMap.item(j).getNodeValue()));
                        }
                    }
                }
            }
        }
    }

    private static void readXMLfilePassengerWagon(ArrayList<PassengerWagon> list, NodeList nodeList) throws Exception {

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals("wagon")) {
                NamedNodeMap nodeMap = nodeList.item(i).getAttributes();
                int count = 0;
                for (int j = 0; j < nodeMap.getLength(); j++) {
                    if (nodeMap.item(j).getNodeName().equals("count")) {
                        count = Integer.parseInt(nodeMap.item(j).getNodeValue());
                    }
                    if (nodeMap.item(j).getNodeName().equals("type")) {
                        for (int k = 0; k < count; k++) {
                            list.add(createPassengerWagon(nodeMap.item(j).getNodeValue()));
                        }
                    }
                }
            }
        }
    }

    private static void readXMLfileFreightWagon(ArrayList<FreightWagon> list, NodeList nodeList) throws Exception {

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals("wagon")) {
                NamedNodeMap nodeMap = nodeList.item(i).getAttributes();
                int count = 0;
                for (int j = 0; j < nodeMap.getLength(); j++) {
                    if (nodeMap.item(j).getNodeName().equals("count")) {
                        count = Integer.parseInt(nodeMap.item(j).getNodeValue());
                    }
                    if (nodeMap.item(j).getNodeName().equals("type")) {
                        for (int k = 0; k < count; k++) {
                            list.add(createFreightWagon(nodeMap.item(j).getNodeValue()));
                        }
                    }
                }
            }
        }
    }

    public static String returnDataAboutTrain(String nameRoute, String path, String attribute) throws Exception {

        NodeList nodeList = createNodeList(path);
        try {
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeName().equals("route")) {
                    NamedNodeMap nodeMap = nodeList.item(i).getAttributes();
                    for (int j = 0; j < nodeMap.getLength(); j++) {
                        if (nodeMap.item(j).getNodeValue().equals(nameRoute)) {
                            NodeList nodeListElement = nodeList.item(i).getChildNodes();
                            for (int k = 0; k < nodeListElement.getLength(); k++) {
                                if (nodeListElement.item(k).getNodeName().equals(attribute)) {
                                    return getElementContent(nodeListElement.item(k));
                                }
                            }
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Нет данных об этом поезде");
            throw new NullPointerException();
        }
        return null;
    }

    private static NodeList createNodeList(String nameFile) {
        File input = new File(nameFile);
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(input);
            doc.getDocumentElement().normalize();
            return doc.getDocumentElement().getChildNodes();

        } catch (Exception e) {
            System.out.println("Невозможно получить данные из файла " + nameFile);
        }
        return null;
    }

    private static Locomotives createLocomotive(String type) throws Exception {
        try {
            if (type.equals("ElectricLocomotive")) {
                return new ElectricLocomotive();
            } else if (type.equals("GasTurbinesLocomotive")) {
                return new GasTurbinesLocomotive();
            } else if (type.equals("HeatLocomotive")) {
                return new HeatLocomotive();
            } else if (type.equals("VaporLocomotive")) {
                return new VaporLocomotive();
            } else return null;
        } catch (NullPointerException e) {
            System.out.println("Такого типа локомотивов не существует");
            throw new NullPointerException();
        }
    }

    private static PassengerWagon createPassengerWagon(String type) throws Exception {
        try {
            if (type.equals("CoupeSVWagon")) {
                return new CoupeSVWagon();
            } else if (type.equals("CoupeNormalWagon")) {
                return new CoupeNormalWagon();
            } else if (type.equals("EconomPassengerWagon")) {
                return new EconomPassengerWagon();
            } else if (type.equals("PassengerWagonWithSeating")) {
                return new PassengerWagonWithSeating();
            } else if (type.equals("CoupeWagonWithSeating")) {
                return new CoupeWagonWithSeating();
            } else return null;
        } catch (NullPointerException e) {
            System.out.println("Такого типа пассажирских вагонов не существует");
            throw new NullPointerException();
        }
    }

    private static FreightWagon createFreightWagon(String type) throws Exception {
        try {
            if (type.equals("CisternFreightWagon")) {
                return new CisternFreightWagon();
            } else if (type.equals("CoverredFreightWagon")) {
                return new CoverredFreightWagon();
            } else if (type.equals("IsothermalFreightWagon")) {
                return new IsothermalFreightWagon();
            } else if (type.equals("PlatformFreightWagon")) {
                return new PlatformFreightWagon();
            } else return null;
        } catch (NullPointerException e) {
            System.out.println("Такого типа грузовых вагонов не существует");
            throw new NullPointerException();
        }
    }

    private static String getElementContent(Node node) {

        Node contentNode = node.getFirstChild();
        if (contentNode != null)

            if (contentNode.getNodeName().equals("#text")) {
                String value = contentNode.getNodeValue();
                if (value != null)
                    return value.trim();
            }
        return null;
    }
}
