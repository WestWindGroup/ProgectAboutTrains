package ua.com.westwind.project.model.trainfactory;

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
