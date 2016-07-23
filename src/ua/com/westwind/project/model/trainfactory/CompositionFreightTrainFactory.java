package ua.com.westwind.project.model.trainfactory;

public class CompositionFreightTrainFactory implements FreightTrainFactory {
    private String nameFile;

    public CompositionFreightTrainFactory(String nameFile) {
        this.nameFile = nameFile;
    }


    @Override
    public FreightTrains createTrain(String route) {
        return null;
    }


}
