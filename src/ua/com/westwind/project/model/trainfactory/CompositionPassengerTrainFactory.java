package ua.com.westwind.project.model.trainfactory;

public class CompositionPassengerTrainFactory implements PassengerTrainFactory {

    private String nameFile;

    public CompositionPassengerTrainFactory(String nameFile) {
        this.nameFile = nameFile;
    }

    @Override
    public PassengerTrains createTrain(String route) {
        return XMLFileParsing.readXMLfileComposition(route,nameFile);
    }
}
