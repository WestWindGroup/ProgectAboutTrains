package ua.com.westwind.project.model.trainfactory;

public class CompositionPassengerTrainFactory implements PassengerTrainFactory {

    private String nameFile;

    public CompositionPassengerTrainFactory(String nameFile) {
        this.nameFile = nameFile;
    }

    @Override
    public PassengerTrain createTrain(String route) throws Exception {
        return XMLFileParsing.readXMLfileCompositionPassengerTrain(route,nameFile);
    }
}
