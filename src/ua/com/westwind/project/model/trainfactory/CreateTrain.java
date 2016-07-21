package ua.com.westwind.project.model.trainfactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ua.com.westwind.project.model.Train;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class CreateTrain {
    private String pathFile;
    private String typeTrain;

    public Train routeTrainInObjectTrain(String route){
        returnDataAboutTrain(route);
        return returnTrain().createTrain();
    }
    private TrainFactory returnTrain(){
        if(typeTrain.equals("CompositionPassengerTrain")){
            return new CompositionPassengerTrainFactory(pathFile);
        }else if(typeTrain.equals("IntercityTrain")){
            return new IntercityTrainFactory(pathFile);
        }else if(typeTrain.equals("CompositionFreightTrain")){
            return new CompositionFreightTrainFactory(pathFile);
        }
        return null;
    }

    private void returnDataAboutTrain(String nameRoute){
        final String PATH = "BaseRouteTrains.xml";

        File input = new File(PATH);

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(input);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++){
                if(nodeList.item(i).getNodeName().equals("route")){
                    NamedNodeMap nodeMap = nodeList.item(i).getAttributes();
                    for (int j = 0; j < nodeMap.getLength(); j ++){
                        if(nodeMap.item(j).getNodeValue().equals(nameRoute)){
                            NodeList nodeListElement = nodeList.item(i).getChildNodes();
                            for (int k = 0; k < nodeListElement.getLength(); k++) {
                                if(nodeListElement.item(k).getNodeName().equals("typeTrain")){
                                    typeTrain = getElementContent(nodeListElement.item(k));
                                }
                                if(nodeListElement.item(k).getNodeName().equals("file")){
                                    pathFile = getElementContent(nodeListElement.item(k));
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }




    }
    private String getElementContent(Node node) {

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
