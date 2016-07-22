package ua.com.westwind.project.model.trainfactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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

    private void returnDataAboutTrain(String route){

        typeTrain = XMLFileParsing.returnDataAboutTrain(route,"typeTrain");
        pathFile = XMLFileParsing.returnDataAboutTrain(route,"file");

    }
}
