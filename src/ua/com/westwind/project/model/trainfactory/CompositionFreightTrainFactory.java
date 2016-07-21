package ua.com.westwind.project.model.trainfactory;

import ua.com.westwind.project.model.Train;
import ua.com.westwind.project.model.compositiontarins.CompositionFreightTrain;

public class CompositionFreightTrainFactory implements TrainFactory{
    private String nameFile;

    public CompositionFreightTrainFactory(String nameFile) {
        this.nameFile = nameFile;
    }


    @Override
    public Train createTrain() {
        return null;
    }


}
