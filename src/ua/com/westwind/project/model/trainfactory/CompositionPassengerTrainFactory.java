package ua.com.westwind.project.model.trainfactory;

import ua.com.westwind.project.model.Train;
import ua.com.westwind.project.model.compositiontarins.CompositionPassengerTrain;

public class CompositionPassengerTrainFactory implements TrainFactory{

    private String nameFile;

    public CompositionPassengerTrainFactory(String nameFile) {
        this.nameFile = nameFile;
    }

    @Override
    public Train createTrain() {
        return new CompositionPassengerTrain();
    }
}
