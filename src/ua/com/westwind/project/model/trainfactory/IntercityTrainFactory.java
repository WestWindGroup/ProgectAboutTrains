package ua.com.westwind.project.model.trainfactory;

import ua.com.westwind.project.model.Train;
import ua.com.westwind.project.model.intercity.IntercityTrains;

public class IntercityTrainFactory implements TrainFactory{
    private String nameFile;

    public IntercityTrainFactory(String nameFile) {
        this.nameFile = nameFile;
    }

    @Override
    public Train createTrain() {
        return XMLFileParsing.readXMLfileIntercity(nameFile);
    }


}
