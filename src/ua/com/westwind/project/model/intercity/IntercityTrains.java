package ua.com.westwind.project.model.intercity;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ua.com.westwind.project.model.RollingStock;
import ua.com.westwind.project.model.Train;
import ua.com.westwind.project.model.wagons.passengerwagons.IntercityTypeWagon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public abstract class IntercityTrains implements RollingStock, Train {
    protected String nameTrain;
    protected int countWagonAmount;
    protected int countWagonFirstClass;
    protected int countWagonSecondClass;
    protected int countWagonFirstAndSecondClass;
    protected ArrayList<IntercityWagon> listInterCityWagon = new ArrayList<>();

    protected void parsingXML(){
        final String PATH = "IntercityTrainInfo.xml";

        File input = new File(PATH);

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(input);
            doc.getDocumentElement().normalize();
            parseNode(doc.getDocumentElement());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseNode(Node node) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++){
            if(nodeList.item(i).getNodeName().equals(nameTrain)){
                NodeList nodeListElement = nodeList.item(i).getChildNodes();
                for (int j = 0; j < nodeListElement.getLength(); j++) {
                    if(nodeListElement.item(j).getNodeName().equals("#text")){
                        continue;
                    }
                    IntercityWagon intercityWagon = parsingElement(nodeListElement.item(j));
                    listInterCityWagon.add(intercityWagon);
                }
            }
        }

    }

    private IntercityWagon parsingElement(Node node){
        IntercityTypeWagon typeWagon = null;
        int countPlaceFirstClass = 0;
        int countPlaceSecondClass = 0;
        NamedNodeMap nodeMap = node.getAttributes();
        if (nodeMap != null) {
            for (int i = 0; i < nodeMap.getLength(); i ++){
                if(nodeMap.item(i).getNodeName().equals("type")){
                    typeWagon = IntercityTypeWagon.valueOf(nodeMap.item(i).getNodeValue());
                    switch (typeWagon) {
                        case WAGON_1_CLASS:
                            countWagonFirstClass++;
                            break;

                        case WAGON_2_CLASS:
                            countWagonSecondClass++;
                            break;

                        case WAGON_1_AND_2_CLASSES:
                            countWagonFirstAndSecondClass++;
                            break;
                    }
                    continue;
                }
                if(nodeMap.item(i).getNodeName().equals("countPlace1")){
                    countPlaceFirstClass = Integer.parseInt(nodeMap.item(i).getNodeValue());
                    continue;
                }
                if(nodeMap.item(i).getNodeName().equals("countPlace2")){
                    countPlaceSecondClass = Integer.parseInt(nodeMap.item(i).getNodeValue());
                    continue;
                }
            }
        }
        return new IntercityWagon(typeWagon,countPlaceFirstClass,countPlaceSecondClass);
    }

    @Override
    public String toString() {
        return "IntercityTrains{" +
                "nameTrain='" + nameTrain + '\'' +
                ", countWagonAmount=" + countWagonAmount +
                ", countWagonFirstClass=" + countWagonFirstClass +
                ", countWagonSecondClass=" + countWagonSecondClass +
                ", countWagonFirstAndSecondClass=" + countWagonFirstAndSecondClass +
                ", listInterCityWagon=" + listInterCityWagon +
                '}';
    }
}
